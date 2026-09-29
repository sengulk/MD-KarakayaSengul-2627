package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // "witruimte"
        Spacer(modifier = Modifier.height(48.dp))

        // LOGO + NAAM + TITEL
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(R.drawable.ic_launcher_foreground)
            Image(
                painter = image,
                contentDescription = null,
                Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(R.string.name),
                fontSize =32.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = stringResource(R.string.role),
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3DDC84),
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // CONTACTGEGEVENS
        Column(
            modifier = Modifier.padding(bottom = 32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            ContactRow(
                icon = painterResource(R.drawable.phone),
                text = stringResource(R.string.number)
            )
            ContactRow(
                icon = painterResource(R.drawable.social),
                text = stringResource(R.string.github)
            )
            ContactRow(
                icon = painterResource(R.drawable.mail),
                text = stringResource(R.string.mail)
            )
        }
    }
}

@Composable
fun ContactRow(
    icon: Painter,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color(0xFF3DDC84),
            modifier = Modifier
                .size(50.dp)
                .padding(end = 16.dp)
        )
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
