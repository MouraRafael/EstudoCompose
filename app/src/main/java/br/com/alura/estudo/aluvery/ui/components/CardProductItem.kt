package br.com.alura.estudo.aluvery.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.alura.estudo.aluvery.R
import br.com.alura.estudo.aluvery.extensions.toCurrency
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme
import br.com.alura.estudo.aluvery.ui.theme.Indigo400Light
import coil.compose.AsyncImage
import java.math.BigDecimal


@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    expanded:Boolean = false
) {
    var expandedState by remember {
        mutableStateOf(expanded)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                expandedState = !expandedState
            },
        elevation  = CardDefaults.cardElevation(defaultElevation = elevation)

    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Indigo400Light)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toCurrency()
                )
            }
             product.description?.let {
                val textOverflow = if (expandedState) TextOverflow.Visible else TextOverflow.Ellipsis
                 val maxLines = if(expandedState) Int.MAX_VALUE else 2
                 Text(
                     text = product.description,
                     Modifier
                         .padding(16.dp),
                     maxLines = maxLines,
                     overflow = textOverflow
                 )
             }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Refrigerante",
                    price = BigDecimal("4.99"),
                    image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
                ),
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun CardProductItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Refrigerante",
                    price = BigDecimal("4.99"),
                    image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg",
                    description = LoremIpsum(50).values.first()
                ),
            )
        }
    }
}
