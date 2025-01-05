package org.assignment_life_easy.project.di

import org.assignment_life_easy.project.ApiClient
import org.assignment_life_easy.project.MyRepository
import org.koin.core.module.Module
import org.koin.dsl.module


val sharedModule: Module = module {

    single { ApiClient(httpClient = get()) }
    single { MyRepository(apiClient = get()) }
}