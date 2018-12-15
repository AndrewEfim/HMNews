package com.example.andreii.mysuperarchitecturealbum.presentation.fucturies


import com.example.andreii.mysuperarchitecturealbum.presentation.executor.UIThread
import com.example.data.net.RestService
import com.example.data.repositories.AlbumRepositotyImpl
import com.example.data.repositories.BandsRepositoryImpl
import com.example.data.repositories.NewsRepositoryImpl
import com.example.domain.usecases.*

object UseCaseProvider {

    var data: String = "https://api.backendless.com/3893C5E2-9BD1-A9D0-FFAF-578551CA9B00/4913DCA6-FB11-5DB3-FF95-B17903816C00/data/"//albumslist
    val restService = RestService(data)
    val uiThread = UIThread()
    val newsRpstr = NewsRepositoryImpl(restService)
    val bndsRpstr = BandsRepositoryImpl(restService)
    val albumRpstr = AlbumRepositotyImpl(restService)

    fun provideNewsListUseCase(): GetNewsUseCase {
        return GetNewsUseCase(uiThread, newsRpstr)
    }

    fun provideNewsByIdUseCase(): GetNewsByIdUseCase {
        return GetNewsByIdUseCase(uiThread, newsRpstr)
    }

    fun provideBandsListUseCase(): GetBandsUseCase {
        return GetBandsUseCase(uiThread, bndsRpstr)
    }




    fun providerAlbumIdUseCase(): GetAlbumByIdUseCase {
        return GetAlbumByIdUseCase(uiThread, albumRpstr)
    }

    fun provideAlbumSearchUseCase(): SearchAlbumsUseCase {
        return SearchAlbumsUseCase(uiThread, albumRpstr)
    }

    fun provideAlbumSerchByNameUseCase(): AlbumSearchByNameUseCase {
        return AlbumSearchByNameUseCase(uiThread, albumRpstr)
    }

}