package com.example.routing

import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.mcHistory() {
    get("/mc") {
        call.respondText("Founded in 1880 as St. Mark's (West Gorton), it became Ardwick Association Football Club in 1887 and Manchester City in 1894. The club's home ground is the City of Manchester Stadium in east Manchester, to which it moved in 2003, having played at Maine Road since 1923.")
    }
}

fun Route.getAllMcPlayers() {
    get("/mc/players") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester City" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllMcForwards() {
    get("/mc/players/forwards") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester City" }.filter { it.position == "forward" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllMcMidfielder() {
    get("/mc/players/midfielders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester City" }.filter { it.position == "midfielder" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllMcDefenders() {
    get("/mc/players/defenders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester City" }.filter { it.position == "defender" }
            .let { players -> call.respond(players) }
    }
}
fun Route.getAllMcGoalkeepers() {
    get("/mc/players/goalkeepers") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Manchester City" }.filter { it.position == "goalkeeper" }
            .let { players -> call.respond(players) }
    }
}