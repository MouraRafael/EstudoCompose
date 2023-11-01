package br.com.alura.estudo.aluvery.dao

import br.com.alura.estudo.aluvery.sampledata.sampleProducts

class ProductDao {

    companion object{
        val products = sampleProducts.toMutableList()
    }

    fun products() = products.toList()
}