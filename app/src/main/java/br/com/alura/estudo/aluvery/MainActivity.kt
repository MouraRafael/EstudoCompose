package br.com.alura.estudo.aluvery

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

@Preview(name = "Preview 1", heightDp = 50, widthDp = 50, showBackground = true, backgroundColor = 0xAAAAFF)
@Preview(name = "Preview 2", showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Preview 3", showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun MyFirstComposablePreview(){
    MyFirstComposable()
}