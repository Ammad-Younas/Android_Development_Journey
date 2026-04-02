package com.madirwx.recipeapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _recipeState = mutableStateOf(RecipeState())
    val recipesState : State<RecipeState> = _recipeState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getResponse()
                _recipeState.value = _recipeState.value.copy(
                    loading = false,
                    recipesList = response.categories,
                    error = null
                )
            } catch (e: Exception){
                _recipeState.value = _recipeState.value.copy(
                    loading = false,
                    error = "Error fetching recipes ${e.message}"
                )
            }
        }
    }


    data class RecipeState (
        val loading : Boolean = true,
        val recipesList : List<Category> = emptyList(),
        val error : String? = null
    )
}