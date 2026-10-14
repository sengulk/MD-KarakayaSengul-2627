package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtwork by remember { mutableIntStateOf(1) }

    val imageResource = when (currentArtwork) {
        1 -> R.drawable.img1
        2 -> R.drawable.img2
        3 -> R.drawable.img3
        4 -> R.drawable.img4
        5 -> R.drawable.img5
        else -> R.drawable.img6
    }

    val title = when (currentArtwork) {
        1 -> "Hemelvaart der Engelen"
        2 -> "Kasteel op de Rots"
        3 -> "Abstracte Geometrie"
        4 -> "Maannacht aan zee"
        5 -> "Zonnevloed"
        else -> "Mysterieus Bos"
    }

    val artist = when (currentArtwork) {
        1 -> "Klassieke Meester (1750)"
        2 -> "Historische Schilder (1890)"
        3 -> "Moderne Kunstenaar (2021)"
        4 -> "Nocturne Schilder (2022)"
        5 -> "Kleurenstudie (2023)"
        else -> "Lanschapsschilder (2020)"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        ArtworkImage(imageResource = imageResource)

        ArtworkDescription(title = title, artist = artist)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentArtwork = when (currentArtwork) {
                        1 -> 6
                        else -> currentArtwork - 1
                    }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text("Vorige")
            }

            Button(
                onClick = {
                    currentArtwork = when (currentArtwork) {
                        6 -> 1
                        else -> currentArtwork + 1
                    }
                },
                modifier = Modifier.width(120.dp)
            ) {
                Text("Volgende")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ArtworkImage(imageResource: Int) {
    Surface(
        modifier = Modifier
            .shadow(8.dp)
            .padding(16.dp),
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .padding(24.dp)
                .size(300.dp)
        )
    }
}

@Composable
fun ArtworkDescription(title: String, artist: String) {
    Column(
        modifier = Modifier
            .background(Color(0xFFECECEC), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            .fillMaxWidth(0.9f),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = artist,
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}