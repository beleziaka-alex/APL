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

    }
}
