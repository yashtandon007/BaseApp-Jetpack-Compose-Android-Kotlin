package com.merttoptas.composebase.data.remote.source.impl

import com.merttoptas.composebase.data.model.CharacterInfoResponse
import com.merttoptas.composebase.data.model.CharacterResponse
import com.merttoptas.composebase.data.remote.api.CharacterService
import com.merttoptas.composebase.data.remote.source.CharacterRemoteDataSource
import com.merttoptas.composebase.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by merttoptas on 12.03.2022
 */
class CharacterRemoteDataSourceImpl @Inject constructor(private val characterService: CharacterService) :
    BaseRemoteDataSource(), CharacterRemoteDataSource {

    override  fun getAllCharacters(page: Int): Flow<DataState<CharacterResponse>> =
        getResult { characterService.getAllCharacters(page = page) }

    override  fun getCharacter(characterId: Int): Flow<DataState<CharacterInfoResponse>> =
        getResult { characterService.getCharacter(characterId = characterId) }

    override  fun getCharacter(url: String): Flow<DataState<CharacterInfoResponse>> =
        getResult {
            characterService.getCharacter(url)
        }
}
