package br.com.ale.testretrofit.repositories

import br.com.ale.testretrofit.models.ValorantModel

interface ValorantRepository {
    suspend fun getAgents() : ValorantModel
}