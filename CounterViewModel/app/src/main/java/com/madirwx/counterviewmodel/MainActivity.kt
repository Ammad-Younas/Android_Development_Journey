package com.madirwx.counterviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madirwx.counterviewmodel.ui.theme.CounterViewModelTheme
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel : CounterViewModel = viewModel()

            CounterViewModelTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                ) { innerPadding ->
                    Surface (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        TheCounterApp(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun TheCounterApp(viewModel : CounterViewModel){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Count: ${viewModel.count.value}",
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 40.dp)
        ) {
            Button (
                onClick = { viewModel.increment() }
            ) {
                Text("Increment")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button (
                onClick = { viewModel.decrement() }
            ) {
                Text("Decrement")
            }
        }
    }
}
