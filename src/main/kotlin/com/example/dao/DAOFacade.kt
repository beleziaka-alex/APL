package com.example.dao

import com.example.models.Player

interface DAOFacade {
    suspend fun getAllPlayers(): List<Player>
    suspend fun getPlayer(id: Int): Player?
    suspend fun addNewPlayer(
        name: String,
        team: String,
        number: Int,
        skill: Int,
        position: String,
        country: String
    ): Player?
    suspend fun deletePlayers(id: Int): Boolean
}