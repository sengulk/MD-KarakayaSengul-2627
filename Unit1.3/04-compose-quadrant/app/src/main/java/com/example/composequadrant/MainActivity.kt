package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import com.example.composequadrant.ui.theme.Q1Color
import com.example.composequadrant.ui.theme.Q2Color
import com.example.composequadrant.ui.theme.Q3Color
import com.example.composequadrant.ui.theme.Q4Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                QuadrantScreen()
            }
        }
    }
}

@Composable
fun QuadrantScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // bovenste helft
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.text_title),
                description = stringResource(R.string.text_desc),
                backgroundColor = Q1Color,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(R.string.image_title),
                description = stringResource(R.string.image_desc),
                backgroundColor = Q2Color,
                modifier = Modifier.weight(1f)
            )
        }

        // onderste helft
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.row_title),
                description = stringResource(R.string.row_desc),
                backgroundColor = Q3Color,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(R.string.column_title),
                description = stringResource(R.string.column_desc),
                backgroundColor = Q4Color,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantScreenPreview() {
    ComposeQuadrantTheme() {
        QuadrantScreen()
    }
}