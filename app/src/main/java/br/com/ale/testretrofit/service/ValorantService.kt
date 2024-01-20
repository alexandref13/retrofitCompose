package br.com.ale.testretrofit.service

import br.com.ale.testretrofit.models.ValorantModel
import retrofit2.http.GET

interface ValorantService {
    @GET("agents")
    suspend fun getAgents(): ValorantModel
}