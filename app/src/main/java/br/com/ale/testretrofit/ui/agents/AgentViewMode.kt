package br.com.ale.testretrofit.ui.agents

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.testretrofit.models.AgentModel
import br.com.ale.testretrofit.repositories.ValorantRepositoryImp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AgentViewMode : ViewModel() {
    private val repository = ValorantRepositoryImp()

    private val _agents = MutableStateFlow(emptyList<AgentModel>())
    val agent: StateFlow<List<AgentModel>> = _agents.asStateFlow()



    fun fetchAgents() {
        viewModelScope.launch {
            try {
                val response = repository.getAgents()
                _agents.value = response.data
            } catch (e: Exception) {
                Log.d("EXC", "FetchAgents: ${e.message.toString()}")
            }
        }
    }
}