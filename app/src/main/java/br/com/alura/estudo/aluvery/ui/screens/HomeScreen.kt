package br.com.alura.estudo.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleCandies
import br.com.alura.estudo.aluvery.sampledata.sampleDrinks
import br.com.alura.estudo.aluvery.sampledata.sampleProducts
import br.com.alura.estudo.aluvery.sampledata.sampleSections
import br.com.alura.estudo.aluvery.ui.components.CardProductItem
import br.com.alura.estudo.aluvery.ui.components.ProductsSection
import br.com.alura.estudo.aluvery.ui.components.SearchTextField
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme
import br.com.alura.estudo.aluvery.ui.viewmodels.HomeScreenViewModel


class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchTextChanged: (String) -> Unit ={}
) {



    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }


}

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    products: List<Product>
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }


    fun containsInNameOrDescription() = { p: Product ->
        p.name.contains(
            text,
            ignoreCase = true
        ) || p.description?.contains(
            text,
            ignoreCase = true
        ) ?: false
    }
    val searchedProducts = if (text.isNotBlank()) {
        sampleProducts.filter(containsInNameOrDescription())
    } else emptyList()





    val sections: Map<String, List<Product>> = mapOf(
        "Todos os Produtos" to products,
        "Promoções" to sampleDrinks + sampleCandies,
        "Doces" to sampleCandies,
        "bebidas" to sampleDrinks
    )
    val state = viewModel.uiState

    val oldstate=remember(products,text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            searchText = text,
            onSearchTextChanged = {
                text = it
            }
        )
    }
    HomeScreen(state = state)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {

    val sections = state.sections
    val text = state.searchText
    val searchedProducts = state.searchedProducts


    Column {
        SearchTextField(
            searchText = text,
            onSearchTextChanged = state.onSearchTextChanged
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)

        ) {
            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(title = title, products = products)
                    }
                }
            } else {
                items(searchedProducts) { produto ->
                    CardProductItem(product = produto, Modifier.padding(horizontal = 16.dp))

                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


@Preview
@Composable
fun HomeScreenPreviewWithSearchText() {
    AluveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections, searchText = "a"))
        }
    }
}