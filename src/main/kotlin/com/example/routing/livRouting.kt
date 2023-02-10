package com.example.routing

import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.livHistory() {
    get("/liv") {
        call.respondText("Liverpool Football Club is a professional football club based in Liverpool, England. The club competes in the Premier League, the top tier of English football. Founded in 1892, the club joined the Football League the following year and has played its home games at Anfield since its formation. ")
    }
}

fun Route.getAllLivPlayers() {
    get("/liv/players") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Liverpool" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllLivForwards() {
    get("/liv/players/forwards") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Liverpool" }.filter { it.position == "forward" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllLivMidfielder() {
    get("/liv/players/midfielders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Liverpool" }.filter { it.position == "midfielder" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllLivDefenders() {
    get("/liv/players/defenders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Liverpool" }.filter { it.position == "defender" }
            .let { players -> call.respond(players) }
    }
}
fun Route.getAllLivGoalkeepers() {
    get("/liv/players/goalkeepers") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Liverpool" }.filter { it.position == "goalkeeper" }
            .let { players -> call.respond(players) }
    }
}