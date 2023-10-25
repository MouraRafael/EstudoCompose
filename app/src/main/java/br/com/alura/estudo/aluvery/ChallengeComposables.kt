package br.com.alura.aluvery.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.estudo.aluvery.R
import br.com.alura.estudo.aluvery.ui.theme.Purple200
import br.com.alura.estudo.aluvery.ui.theme.Purple500
import br.com.alura.estudo.aluvery.ui.theme.Teal200


//@Preview(showBackground = true)
@Composable
fun ChallengeComposable() {
    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp
    ) {
        Row(
            Modifier
                .height(height = 200.dp)
                .fillMaxWidth()
        ) {
            val imageSize = 100.dp
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(imageSize)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Purple500, Purple200
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .align(Alignment.Center)
                        .offset(x = imageSize / 2)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(
                                2.dp, brush = Brush.verticalGradient(
                                    listOf(
                                        Purple200, Purple500
                                    )
                                )
                            ), CircleShape
                        )
                )
            }
            Spacer(Modifier.width(imageSize / 2))
            Box(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .padding(16.dp)
                    .align(CenterVertically),
            ) {
                Column {
                    Text(
                        text = LoremIpsum(50).values.first(),
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Desafio2Composable() {
    Surface(
        modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp
    ) {
        Row(
            Modifier
                .heightIn(50.dp, 200.dp)
                .widthIn(200.dp, 500.dp)
        ) {
            val imageSize = 100.dp
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(imageSize)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .offset(x = (imageSize / 2))
                        .size(imageSize)
                        .clip(shape = CircleShape)
                        .align(Alignment.CenterEnd)
//                        .border(
//
//                            BorderStroke(
//
//                                2.dp, brush = Brush.verticalGradient(
//
//                                    listOf(
//
//                                        Purple200, Purple500
//
//                                    )
//
//                                )
//
//                            ), CircleShape
//
//                        )
                )
            }
            Spacer(modifier = Modifier.width(imageSize / 2))

            Box(
                Modifier
                    .padding(16.dp)

                    .fillMaxHeight()

                    .padding(16.dp)

                    .align(CenterVertically),
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        text = LoremIpsum(50).values.first(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis

                    )
                    Text(
                        text = "R$ 15,99",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }

    }
}

//@Preview(showBackground = true)
//@Preview
@Composable
fun DesafioLayout() {

    Row(
        Modifier.height(150.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .background(Color.Blue)
        ) {}
        Column() {
            Text(
                text = "Test 1",
                Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFededed))
                    .padding(16.dp)
            )
            Text(text = "Test 2", Modifier.padding(16.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChallengeComposoableScrollPreview() {
    ChallengeProductSectionScroll()
}


@Composable
fun ChallengeComposoableScroll(description: String = "") {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())

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
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .offset(y = (imageSize / 2))
                        .size(imageSize)
                        .clip(shape = CircleShape)
                        .align(BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))

            Column(Modifier.padding(16.dp)) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis

                )
                Text(
                    text = "R$ 15,99",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(top = 8.dp)
                )

            }
            if (description.isNotBlank()) {
                Text(
                    text = description,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        }

    }

}

@Composable
fun ChallengeProductSectionScroll() {
    Column(
    ) {
        Text(
            text = "Promoções",
            fontWeight = FontWeight(400),
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        Row(
            Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState(16))
                .padding(horizontal = 16.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            ChallengeComposoableScroll(LoremIpsum(500).values.first())
            ChallengeComposoableScroll()
            ChallengeComposoableScroll(LoremIpsum(20).values.first())

        }
    }

}