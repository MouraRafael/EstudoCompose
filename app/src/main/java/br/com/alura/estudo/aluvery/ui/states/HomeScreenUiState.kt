package br.com.alura.estudo.aluvery.ui.states

import br.com.alura.estudo.aluvery.model.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchTextChanged: (String) -> Unit ={}
) {



    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }


}