package com.example.routing

import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.cheHistory() {
    get("/che") {
        call.respondText("Chelsea FC was founded in 1905 by Henry Augustus Mears. Home games are played at Stamford Bridge stadium, the original site Mears chose for the club. The team had mixed fortunes over the years, not winning a major trophy until the 1950s and moving up and down between divisions several times.")
    }
}

fun Route.getAllChePlayers() {
    get("/che/players") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Chelsea" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllCheForwards() {
    get("/che/players/forwards") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Chelsea" }.filter { it.position == "forward" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllCheMidfielder() {
    get("/che/players/midfielders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Chelsea" }.filter { it.position == "midfielder" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllCheDefenders() {
    get("/che/players/defenders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Chelsea" }.filter { it.position == "defender" }
            .let { players -> call.respond(players) }
    }
}
fun Route.getAllCheGoalkeepers() {
    get("/che/players/goalkeepers") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Chelsea" }.filter { it.position == "goalkeeper" }
            .let { players -> call.respond(players) }
    }
}