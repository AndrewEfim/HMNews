package com.example.domain.repositories

import com.example.domain.entity.Band
import io.reactivex.Observable

interface BandsRepository :BaseRepository {

    fun getBands():Observable<List<Band>>
}