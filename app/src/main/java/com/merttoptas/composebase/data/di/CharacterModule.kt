package com.merttoptas.composebase.data.di

import com.merttoptas.composebase.data.remote.api.CharacterService
import com.merttoptas.composebase.data.remote.source.CharacterRemoteDataSource
import com.merttoptas.composebase.data.remote.source.impl.CharacterRemoteDataSourceImpl
import com.merttoptas.composebase.data.repository.CharacterRepositoryImpl
import com.merttoptas.composebase.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

/**
 * Created by merttoptas on 12.03.2022
 */

@Module
@InstallIn(ViewModelComponent::class)
class CharacterModule {
    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService =
        retrofit.create(CharacterService::class.java)

    @Provides
    fun provideCharacterRemoteDataSource(characterService: CharacterService): CharacterRemoteDataSource =
        CharacterRemoteDataSourceImpl(characterService)

    @Provides
    fun provideCharacterRepository(
        accountRemoteDataSource: CharacterRemoteDataSource,
    ): CharacterRepository =
        CharacterRepositoryImpl(accountRemoteDataSource)
}