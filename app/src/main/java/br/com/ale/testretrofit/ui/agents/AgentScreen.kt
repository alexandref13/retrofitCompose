package br.com.ale.testretrofit.ui.agents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.ale.testretrofit.models.AgentModel
import coil.compose.AsyncImage

@Composable
fun AgentScreen(agentViewMode: AgentViewMode = viewModel()) {
    val agents = agentViewMode.agent.collectAsState()

    LaunchedEffect(Unit) {
        agentViewMode.fetchAgents()
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (agents.value.isEmpty()) {
            CircularProgressIndicator()
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp), modifier = Modifier.fillMaxHeight()
            ) {
                items(agents.value) { agent ->
                    Box(modifier = Modifier.padding(8.dp)){
                        Item(agent)
                    }
                }
            }
        }
    }
}

@Composable
fun Item(agent: AgentModel) {
    Box(modifier = Modifier.background(Color(0xFF7d1b72), shape = RoundedCornerShape(8.dp)).padding(8.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = agent.displayName, color= Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(model = agent.displayIcon, contentDescription = "Image of Champion")
        }
    }
}
