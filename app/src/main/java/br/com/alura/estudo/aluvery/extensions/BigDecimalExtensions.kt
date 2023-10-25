package br.com.alura.estudo.aluvery.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toCurrency(langague:String="pt",country:String="br"):String{
    return NumberFormat.getCurrencyInstance(Locale(langague,country)).format(this)
}