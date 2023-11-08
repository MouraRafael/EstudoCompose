package br.com.alura.estudo.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleProducts

class ProductDao {

    companion object{
        val products = mutableStateListOf<Product>(*sampleProducts.toTypedArray())
    }

    fun products() = products.toList()
    fun save(product: Product) {
        products.add(product)
    }
}