package com.madirwx.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.madirwx.shoppinglist.ui.theme.ShoppingListTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showDialog by remember { mutableStateOf(false) }

            ShoppingListTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { showDialog = true },
                            containerColor = Color.Black,
                            contentColor = Color.White,
                            modifier = Modifier
                                .padding(bottom = 48.dp, end = 16.dp)
                                .size(75.dp)
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Add Item",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }

                ) { innerPadding ->

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = Color.White
                    ) {

                        ShoppingListApp(
                            showDialog = showDialog,
                            onDismiss = { showDialog = false }
                        )
                    }
                }
            }
        }
    }
}