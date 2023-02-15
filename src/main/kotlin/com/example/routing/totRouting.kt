package com.example.routing

import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.totHistory() {
    get("/tot") {
        call.respondText("Tottenham Hotspur FC was founded in 1882, by a group of grammar-school boys from All Hallows Church. At first, the club was simply named Hotspur; in order to avoid confusion with an older club named Hotspur FC, the name was soon changed to Tottenham Hotspur.")
    }
}

fun Route.getAllTotPlayers() {
    get("/tot/players") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Tottenham" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllTotForwards() {
    get("/tot/players/forwards") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Tottenham" }.filter { it.position == "forward" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllTotMidfielder() {
    get("/tot/players/midfielders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Tottenham" }.filter { it.position == "midfielder" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllTotDefenders() {
    get("/tot/players/defenders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Tottenham" }.filter { it.position == "defender" }
            .let { players -> call.respond(players) }
    }
}
fun Route.getAllTotGoalkeepers() {
    get("/tot/players/goalkeepers") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Tottenham" }.filter { it.position == "goalkeeper" }
            .let { players -> call.respond(players) }
    }
}