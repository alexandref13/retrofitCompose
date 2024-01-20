package br.com.ale.testretrofit.repositories

import br.com.ale.testretrofit.models.ValorantModel
import br.com.ale.testretrofit.service.ValorantServiceImp

class ValorantRepositoryImp: ValorantRepository {
   private val valorantService = ValorantServiceImp().valorantApiService

    override suspend fun getAgents(): ValorantModel {
       return valorantService.getAgents()
    }
}