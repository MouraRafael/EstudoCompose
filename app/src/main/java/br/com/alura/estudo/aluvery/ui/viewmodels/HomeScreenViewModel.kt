package br.com.alura.estudo.aluvery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.estudo.aluvery.dao.ProductDao
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleCandies
import br.com.alura.estudo.aluvery.sampledata.sampleDrinks
import br.com.alura.estudo.aluvery.sampledata.sampleProducts
import br.com.alura.estudo.aluvery.ui.states.HomeScreenUiState
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()


    var uiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState(
        onSearchTextChanged = {
            uiState = uiState.copy(

                searchText = it,
                searchedProducts = searchedProducts(it)
            )
        }
    ))
        private set

    init {
        viewModelScope.launch {
            dao.products().collect { products ->
                uiState = uiState.copy(
                    sections = mapOf(
                        "Todos os Produtos" to products,
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Doces" to sampleCandies,
                        "bebidas" to sampleDrinks
                    )
                )
            }
        }
    }


    fun containsInNameOrDescription(text: String) = { p: Product ->
        p.name.contains(
            text,
            ignoreCase = true
        ) || p.description?.contains(
            text,
            ignoreCase = true
        ) ?: false
    }

    fun searchedProducts(text: String) = if (text.isNotBlank()) {
        dao.products().value.filter(containsInNameOrDescription(text))
    } else emptyList()


}