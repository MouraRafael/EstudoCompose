package br.com.alura.estudo.aluvery

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.estudo.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposable()
        }
    }


}

@Composable
fun MyFirstComposable() {
    AluveryTheme {
        Surface {
            Text(text = "Meu compose")
            Text(text = "Meu Composito")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ColumnPreview(){
    Column {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
}
@Preview(showBackground = true)
@Composable
fun RowPreview(){
    Row {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
}
@Preview(showBackground = true)
@Composable
fun BoxPreview(){
    Box {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
}
@Preview(showBackground = true)
@Composable
fun CustomLayout(){
    Column {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Row {
            Text(text = "Texto 3")
            Text(text = "Texto 4")
        }
        Box{
            Row {
                Text(text = "Texto 5")
                Text(text = "Texto 6")
            }
            Column {
                Text(text = "Texto 7")
                Text(text = "Texto 8")
            }
        }
    }
}
