package br.com.alura.estudo.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(sections: Map<String, List<Product>>,
               searchText:String = "") {
    var valor: String by remember {
        mutableStateOf(searchText)
    }

    val produtos = remember(valor){
    //Este remember faz com que a filtro só seja executado novamente caso haja uma mudança na variavel valor
        if(valor.isNotBlank()){sampleProducts.filter { p ->
            p.name.contains(valor, ignoreCase = true) ||
                    p.description?.contains(valor, ignoreCase = true) ?: false
        }}else emptyList()
    }





    Column {

        OutlinedTextField(
            value = valor,
            onValueChange = { newValue ->
                valor = newValue
            },
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Ícone de busca")},
            label = { Text(text = "Produtos")},
            placeholder = { Text(text = "O que você procura?")}

        )
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)

        ) {
            if(valor.isBlank()){
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(title = title, products = products)
                    }
                }
            }else{
                items(produtos){produto->
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