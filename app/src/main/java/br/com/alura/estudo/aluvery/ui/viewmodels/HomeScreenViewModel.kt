package br.com.alura.estudo.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.estudo.aluvery.dao.ProductDao
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleCandies
import br.com.alura.estudo.aluvery.sampledata.sampleDrinks
import br.com.alura.estudo.aluvery.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()


    private var _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(HomeScreenUiState())
    val uiState get() = _uiState.asStateFlow()


    init {

        _uiState.update { currentValue->
                currentValue.copy(
                    onSearchTextChanged = {
                        _uiState.value = _uiState.value.copy(
                            searchText = it,
                            searchedProducts = searchedProducts(it)
                        )
                    }
                )

        }


        viewModelScope.launch {
            dao.products().collect { products ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "Todos os Produtos" to products,
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Doces" to sampleCandies,
                        "bebidas" to sampleDrinks
                    ),
                    searchedProducts = searchedProducts(uiState.value.searchText)
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