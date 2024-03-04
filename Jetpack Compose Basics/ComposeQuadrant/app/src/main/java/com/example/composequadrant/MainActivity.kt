package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        TopRow(
            title1 = stringResource(R.string.text_composable),
            content1 = stringResource(R.string.text_compose_content),
            title2 = stringResource(R.string.image_composable),
            content2 = stringResource(R.string.image_compose_content),
            color1 = Color(0xFFEADDFF),
            color2 = Color(0xFFB69DF8),
            modifier = Modifier
                .weight(1f)
        )
        TopRow(
            title1 = stringResource(R.string.row_composable),
            content1 = stringResource(R.string.row_compose_content),
            title2 = stringResource(R.string.column_composable),
            content2 = stringResource(R.string.column_compose_content),
            color1 = Color(0xFFD0BCFF),
            color2 = Color(0xFFF6EDFF),
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun TopRow(
    title1: String,
    content1: String,
    title2: String,
    content2: String,
    color1:  Color,
    color2: Color,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    )
    {
        QuadrantText(
            title = title1,
            content = content1,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color = color1)
                .padding(16.dp)
        )
        QuadrantText(
            title = title2,
            content = content2,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color = color2)
                .padding(16.dp)

        )
    }
}

@Composable
fun QuadrantText(title: String, content:String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantApp()
    }
}