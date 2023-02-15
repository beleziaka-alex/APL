package com.example.plugins

import com.example.routing.*
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        homePage()
        getAllPlayers()
        getPlayer()
        addNewPlayer()
        deletePlayer()
        muHistory()
        getAllMuPlayers()
        getAllMuForwards()
        getAllMuMidfielder()
        getAllMuDefenders()
        getAllMuGoalkeepers()
        arsHistory()
        getAllArsPlayers()
        getAllArsForwards()
        getAllArsMidfielder()
        getAllArsDefenders()
        getAllArsGoalkeepers()
        getAllMcGoalkeepers()
        getAllMcDefenders()
        getAllMcMidfielder()
        getAllMcForwards()
        getAllMcPlayers()
        mcHistory()
        getAllLivGoalkeepers()
        getAllLivDefenders()
        getAllLivMidfielder()
        getAllLivForwards()
        getAllLivPlayers()
        livHistory()
        cheHistory()
        getAllChePlayers()
        getAllCheForwards()
        getAllCheMidfielder()
        getAllCheDefenders()
        getAllCheGoalkeepers()
        getAllTotGoalkeepers()
        getAllTotDefenders()
        getAllTotMidfielder()
        getAllTotForwards()
        getAllTotPlayers()
        totHistory()

    }
}
