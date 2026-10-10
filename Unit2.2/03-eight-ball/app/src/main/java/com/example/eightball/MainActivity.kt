package com.example.eightball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eightball.ui.theme.EightBallTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EightBallTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EightBall(pickedNumber: Int, modifier: Modifier = Modifier) {
    val textToDisplay = when (pickedNumber) {
        0 -> stringResource(R.string.result_1)
        1 -> stringResource(R.string.result_2)
        2 -> stringResource(R.string.result_3)
        3 -> stringResource(R.string.result_4)
        4 -> stringResource(R.string.result_5)
        5 -> stringResource(R.string.result_6)
        6 -> stringResource(R.string.result_7)
        7 -> stringResource(R.string.result_8)
        8 -> stringResource(R.string.result_9)
        9 -> stringResource(R.string.result_10)
        10 -> stringResource(R.string.result_11)
        11 -> stringResource(R.string.result_12)
        12 -> stringResource(R.string.result_13)
        13 -> stringResource(R.string.result_14)
        14 -> stringResource(R.string.result_15)
        15 -> stringResource(R.string.result_16)
        16 -> stringResource(R.string.result_17)
        17 -> stringResource(R.string.result_18)
        18 -> stringResource(R.string.result_19)
        19 -> stringResource(R.string.result_20)
        else -> ""
    }

    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.bal),
            contentDescription = null
        )
        Text(
            text = textToDisplay,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.5f)
        )
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var pickedNumber by remember { mutableIntStateOf(-1) }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        EightBall(pickedNumber = pickedNumber, modifier = Modifier.padding(8.dp))

        Button(
            onClick = { pickedNumber = (0..19).random() }
        ) {
            Text(text = stringResource(R.string.get_answer))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    EightBallTheme {
        Counter()
    }
}