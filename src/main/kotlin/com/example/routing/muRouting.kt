package com.example.routing

import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.muHistory() {
    get("/mu") {
        call.respondText("Manchester United is one of the most prestigious football clubs and has always maintained a distinguished tradition, a record of consistent success, and a great history. They are together with Liverpool, England's most successful football clubs ever. \"The Red Devils\" have more national titles than Liverpool, but the rival has collected more titles in international tournaments.")
    }
}

fun Route.getAllMuPlayers() {
    get("/mu/players") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester United" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllMuForwards() {
    get("/mu/players/forwards") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester United" }.filter { it.position == "forward" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllMuMidfielder() {
    get("/mu/players/midfielders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester United" }.filter { it.position == "midfielder" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllMuDefenders() {
    get("/mu/players/defenders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester United" }.filter { it.position == "defender" }
            .let { players -> call.respond(players) }
    }
}
fun Route.getAllMuGoalkeepers() {
    get("/mu/players/goalkeepers") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester United" }.filter { it.position == "goalkeeper" }
            .let { players -> call.respond(players) }
    }
}