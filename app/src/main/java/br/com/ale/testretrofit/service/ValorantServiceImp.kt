package br.com.ale.testretrofit.service

import br.com.ale.testretrofit.config.CustomRetrofit

class ValorantServiceImp {
    val valorantApiService: ValorantService by lazy {
        CustomRetrofit.retrofit.create(ValorantService::class.java)
    }
}