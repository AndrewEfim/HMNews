package com.example.data.repositories

import com.example.data.entity.transformToDomain
import com.example.data.net.RestService
import com.example.domain.entity.Band
import com.example.domain.repositories.BandsRepository
import io.reactivex.Observable

class BandsRepositoryImpl(val apiService: RestService) : BandsRepository {


    override fun getBands(): Observable<List<Band>> {
        return apiService.getBands().map { list -> list.map { it.transformToDomain() } }

    }



}