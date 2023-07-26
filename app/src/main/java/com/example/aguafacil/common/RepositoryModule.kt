package com.example.aguafacil.common

import com.example.aguafacil.domain.repository.ProductDBRepository
import com.example.aguafacil.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesRealtimeRepository(
        repo: ProductDBRepository
    ): ProductRepository
}