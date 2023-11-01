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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleProducts
import br.com.alura.estudo.aluvery.sampledata.sampleSections
import br.com.alura.estudo.aluvery.ui.components.CardProductItem
import br.com.alura.estudo.aluvery.ui.components.ProductsSection
import br.com.alura.estudo.aluvery.ui.components.SearchTextField
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme


class HomeScreenUiState(searchText: String){

    var text: String by mutableStateOf(searchText)




    val searchedProducts get() = if(text.isNotBlank()){sampleProducts.filter { p ->
            p.name.contains(text, ignoreCase = true) ||
                    p.description?.contains(text, ignoreCase = true) ?: false
        }}else emptyList()

    fun isStateNotBlank():Boolean {
        return text.isBlank()
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(sections: Map<String, List<Product>>,
               searchText:String = "") {


    val state = remember {
        HomeScreenUiState(searchText)
    }
    val text = state.text

    val searchedProducts = remember(text) {
        state.searchedProducts
    }




    Column {



        SearchTextField(
            searchText = text,
            onSearchTextChanged = {
            state.text =it
        })

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)

        ) {
            if(state.isStateNotBlank()){
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(title = title, products = products)
                    }
                }
            }else{
                items(searchedProducts){produto->
                    CardProductItem(product = produto, Modifier.padding(horizontal = 16.dp))

                }
            }





        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}


@Preview
@Composable
fun HomeScreenPreviewWithSearchText() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections,"Lorem")
        }
    }
}