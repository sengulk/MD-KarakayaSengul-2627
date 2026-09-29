package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticleApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArticleApp(modifier: Modifier = Modifier) {
    // column gebruiken zodat alles onder elkaar komt
    Column(modifier = modifier) {
        // AFBEELDING
        val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth() // volledige breedte afbeelding
        )

        // TITEL
        Text(
            text = stringResource(R.string.title_text),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        // INTRO
        Text(
            text = stringResource(R.string.intro_text),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        // BODY
        Text(
            text = stringResource(R.string.body_text),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        ArticleApp()
    }
}