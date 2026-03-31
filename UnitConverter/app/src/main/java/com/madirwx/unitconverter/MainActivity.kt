package com.madirwx.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madirwx.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Surface (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        UnitConverter()
                    }
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    var userInput by remember { mutableStateOf("") }
    var outputResult by remember { mutableStateOf("") }
    var fromUnitExpanded by remember { mutableStateOf(false) }
    var toUnitExpanded by remember { mutableStateOf(false) }
    var fromUnit by remember { mutableStateOf("Centimeter") }
    var toUnit by remember { mutableStateOf("Centimeter") }
    var fromConversionFactor by remember { mutableDoubleStateOf(0.01) }
    var toConversionFactor by remember { mutableDoubleStateOf(0.01) }


    fun convertUnits(){
        val inputValue = userInput.toDoubleOrNull() ?: 0.0
        val result = inputValue * fromConversionFactor / toConversionFactor
        outputResult = ((result * 100).roundToInt() / 100.0).toString()
    }


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Unit Converter"
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = userInput,
            onValueChange = {
                userInput = it
                convertUnits()
            },
            label = { Text("Enter a value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Result: $outputResult $toUnit")
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Box {
                Button (onClick = {fromUnitExpanded = !fromUnitExpanded}){
                    Text(fromUnit)
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "From"
                    )
                }
                DropdownMenu(expanded = fromUnitExpanded, onDismissRequest = {fromUnitExpanded = false}) {
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            fromUnit = "Centimeter"
                            fromUnitExpanded = false
                            fromConversionFactor = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            fromUnit = "Meter"
                            fromUnitExpanded = false
                            fromConversionFactor = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            fromUnit = "Feet"
                            fromUnitExpanded = false
                            fromConversionFactor = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            fromUnit = "Millimeter"
                            fromUnitExpanded = false
                            fromConversionFactor = 0.001
                            convertUnits()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "To",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Box {
                Button (onClick = {toUnitExpanded = !toUnitExpanded}){
                    Text(toUnit)
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "To"
                    )
                }
                DropdownMenu(expanded = toUnitExpanded, onDismissRequest = {toUnitExpanded = false}) {
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            toUnit = "Centimeter"
                            toUnitExpanded = false
                            toConversionFactor = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            toUnit = "Meter"
                            toUnitExpanded = false
                            toConversionFactor = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            toUnit = "Feet"
                            toUnitExpanded = false
                            toConversionFactor = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            toUnit = "Millimeter"
                            toUnitExpanded = false
                            toConversionFactor = 0.001
                            convertUnits()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}
