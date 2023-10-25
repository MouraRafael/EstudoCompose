package br.com.alura.estudo.aluvery.sampledata

import br.com.alura.estudo.aluvery.R
import br.com.alura.estudo.aluvery.model.Product
import java.math.BigDecimal


val sampleProducts = listOf(
    Product(
        "Hamburger",
        BigDecimal("12.99"),
        R.drawable.burger
    ), Product(
        "Pizza",
        BigDecimal("19.99"),
        R.drawable.pizza
    ), Product(
        "Batata Frita",
        BigDecimal("7.99"),
        R.drawable.fries
    )
)