package com.hegunhee.wirebarleytest.di

import com.hegunhee.wirebarleytest.model.DefaultRepository
import com.hegunhee.wirebarleytest.model.Repository
import com.hegunhee.wirebarleytest.ui.MainViewModel
import com.hegunhee.wirebarleytest.util.getRateApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module{

    viewModel<MainViewModel> { MainViewModel(get()) }

    single<Repository>{ DefaultRepository(get())}
    single{ getRateApi()}
}