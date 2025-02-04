package org.Crick_Bustor.project.di
import org.Crick_Bustor.project.ApiClient
import org.Crick_Bustor.project.MyRepository
import org.koin.core.module.Module
import org.koin.dsl.module


val sharedModule: Module = module {

    single { ApiClient(httpClient = get()) }
    single { MyRepository(apiClient = get()) }
}