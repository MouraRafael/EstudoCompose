package br.com.alura.estudo.aluvery.model

import androidx.annotation.DrawableRes
import br.com.alura.estudo.aluvery.R
import java.math.BigDecimal

class Product(
    val name:String,
    val price:BigDecimal,
    @DrawableRes val image:Int = R.drawable.ic_launcher_background,
){}