package br.com.alura.estudo.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.estudo.aluvery.dao.ProductDao
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleCandies
import br.com.alura.estudo.aluvery.sampledata.sampleDrinks
import br.com.alura.estudo.aluvery.sampledata.sampleProducts
import br.com.alura.estudo.aluvery.sampledata.sampleSections
import br.com.alura.estudo.aluvery.ui.screens.HomeScreen
import br.com.alura.estudo.aluvery.ui.screens.HomeScreenUiState
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {


    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }) {
                val products = dao.products()
                var text by remember {
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
                    sampleProducts.filter(containsInNameOrDescription()) +
                            products.filter(containsInNameOrDescription())
                } else emptyList()





                val sections: Map<String, List<Product>> = mapOf(
                    "Todos os Produtos" to searchedProducts,
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "bebidas" to sampleDrinks
                )
                val state = remember(products,text) {
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
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    AluveryTheme {
        Surface {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = onFabClick) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }

            }
        }
    }
}


@Preview
@Composable
fun AppPreview() {
    App() { HomeScreen(HomeScreenUiState(sampleSections)) }
}