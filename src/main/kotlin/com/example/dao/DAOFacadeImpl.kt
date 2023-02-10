package com.example.dao

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Player
import com.example.models.Players
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToPlayer(row: ResultRow) = Player(
        id = row[Players.id],
        name = row[Players.name],
        team = row[Players.team],
        number = row[Players.number],
        skill = row[Players.skill],
        position = row[Players.position],
        country = row[Players.country]
    )

    override suspend fun getAllPlayers(): List<Player> = dbQuery {
        Players
            .selectAll()
            .map(::resultRowToPlayer)
    }

    override suspend fun getPlayer(id: Int): Player? = dbQuery {
        Players
            .select(Players.id eq id)
            .map(::resultRowToPlayer)
            .singleOrNull()
    }

    override suspend fun addNewPlayer(
        name: String,
        team: String,
        number: Int,
        skill: Int,
        position: String,
        country: String
    ): Player? = dbQuery {
        val playerToAdd = Players.insert {
            it[Players.name] = name
            it[Players.team] = team
            it[Players.number] = number
            it[Players.skill] = skill
            it[Players.position] = position
            it[Players.country] = country
        }
        playerToAdd.resultedValues?.singleOrNull()?.let(::resultRowToPlayer)
    }

    override suspend fun deletePlayers(id: Int): Boolean = dbQuery {
        Players.deleteWhere { Players.id eq id } > 0
    }
}