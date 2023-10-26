package br.com.alura.estudo.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleProducts
import br.com.alura.estudo.aluvery.ui.components.ProductItem

@Composable
fun AllProductsScreen(list:List<Product>){
    LazyVerticalGrid(
        //columns = GridCells.Fixed(2),
        columns = GridCells.Adaptive(minSize = 128.dp),
        Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement=Arrangement.spacedBy(16.dp),

        contentPadding = PaddingValues(16.dp)
    ){
        items(list){
            ProductItem(product =it)
        }
    }
}


@Preview
@Composable
fun AllProductsScreenPreview() {
    AllProductsScreen(list = sampleProducts)
}