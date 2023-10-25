package br.com.alura.estudo.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.estudo.aluvery.R
import br.com.alura.estudo.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection() {
    Column(
    ) {
        Text(
            text = "Promoções",
            fontWeight = FontWeight(400),
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Row(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState(16)),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            ProductItem(
                Product(
                    "Hamburger",
                    BigDecimal("12.99"),
                    R.drawable.burger
                )
            )
            ProductItem(
                Product(
                    "Pizza",
                    BigDecimal("19.99"),
                    R.drawable.pizza
                )
            )
            ProductItem(
                Product(
                    "Batata Frita",
                    BigDecimal("7.99"),
                    R.drawable.fries
                )
            )
            Spacer(Modifier)
        }
    }

}


@Preview
@Composable
fun ProductSectionPreview() {
    ProductSection()
}