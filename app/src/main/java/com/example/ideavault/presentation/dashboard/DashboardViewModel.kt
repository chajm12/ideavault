package com.example.ideavault.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.ideavault.data.repository.IdeaRepository
import com.example.ideavault.domain.model.Idea
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModel(private val repository: IdeaRepository) : ViewModel() {

    private val _sortByDate = MutableStateFlow(true)
    val sortByDate = _sortByDate

    val ideas = _sortByDate
        .flatMapLatest { byDate ->
            if (byDate) repository.getAllIdeasByDate()
            else repository.getAllIdeasByImportance()
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun toggleSort() {
        _sortByDate.value = !_sortByDate.value
    }

    fun saveIdea(title: String, description: String, importance: Int) {
        viewModelScope.launch {
            repository.saveIdea(Idea(title = title, description = description, importance = importance))
        }
    }

    fun deleteIdea(idea: Idea) {
        viewModelScope.launch {
            repository.deleteIdea(idea)
        }
    }
}

class DashboardViewModelFactory(private val repository: IdeaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return DashboardViewModel(repository) as T
    }
}
