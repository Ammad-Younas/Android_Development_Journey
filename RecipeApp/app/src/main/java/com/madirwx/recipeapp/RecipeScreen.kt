package com.madirwx.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen() {
    val recipeViewModel : MainViewModel = viewModel()
    val viewState = recipeViewModel.recipesState

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        when {
            viewState.value.loading -> {
                CircularProgressIndicator (
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            viewState.value.error != null -> {
                Text(
                    "Error Occurred",
                    modifier = Modifier.align(Alignment.Center)

                )
            }
            else -> {
                CategoryScreen(viewState.value.recipesList)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>){
    LazyVerticalGrid (
        GridCells.Fixed(2), modifier = Modifier.fillMaxSize()
    ) {
        items(categories){
            category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = category.strCategory,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)
        )
        Text(
            text = category.strCategory,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}





















