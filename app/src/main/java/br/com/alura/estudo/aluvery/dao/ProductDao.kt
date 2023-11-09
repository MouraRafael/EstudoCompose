package br.com.alura.estudo.aluvery.dao

import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.sampledata.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {

    companion object{
        private val products = MutableStateFlow<List<Product>>(sampleProducts)
        //(*sampleProducts.toTypedArray())
    }

    fun products() = products.asStateFlow()
    fun save(product: Product) {
        products.value = products.value+product
    }
}