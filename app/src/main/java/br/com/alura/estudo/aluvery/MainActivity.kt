package br.com.alura.estudo.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.estudo.aluvery.extensions.toCurrency
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme
import br.com.alura.estudo.aluvery.ui.theme.Purple500
import br.com.alura.estudo.aluvery.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }




}
@Composable
private fun App() {
    AluveryTheme {
        Surface {
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                Spacer(Modifier)
                ProductSection()
                ProductSection()
                ProductSection()
                Spacer(Modifier)
            }
        }
    }
}

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


@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)

        ) {
            val imageSize = 100.dp
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    Modifier
                        .offset(y = (imageSize / 2))
                        .size(imageSize)
                        .clip(shape = CircleShape)
                        .align(BottomCenter),
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))

            Column(Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis

                )
                Text(
                    text = product.price.toCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun AppPreview(){
    App()
}


@Composable
fun ProductSectionPreview() {
    ProductSection()
}

@Composable
fun ProductItemPreview() {
    ProductItem(
        Product(
            LoremIpsum(50).values.first(),
            BigDecimal("15.94"),
            R.drawable.ic_launcher_background
        )
    )
}
