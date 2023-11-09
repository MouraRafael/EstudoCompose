package br.com.alura.estudo.aluvery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.alura.estudo.aluvery.dao.ProductDao
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleCandies
import br.com.alura.estudo.aluvery.sampledata.sampleDrinks
import br.com.alura.estudo.aluvery.sampledata.sampleProducts
import br.com.alura.estudo.aluvery.ui.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()


    var uiState:HomeScreenUiState by mutableStateOf(HomeScreenUiState(
        sections = mapOf(
            "Todos os Produtos" to dao.products(),
            "Promoções" to sampleDrinks + sampleCandies,
            "Doces" to sampleCandies,
            "bebidas" to sampleDrinks
        ),
        onSearchTextChanged = {
            uiState = uiState.copy(

                searchText = it,
                searchedProducts = searchedProducts(it)
            )
        }
    ))
        private set






    fun containsInNameOrDescription(text:String) = { p: Product ->
        p.name.contains(
            text,
            ignoreCase = true
        ) || p.description?.contains(
            text,
            ignoreCase = true
        ) ?: false
    }
    fun searchedProducts(text:String) = if (text.isNotBlank()) {
        sampleProducts.filter(containsInNameOrDescription(text))
    } else emptyList()


}