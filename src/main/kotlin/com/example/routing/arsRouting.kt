package com.example.routing

import com.example.dao.DAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.arsHistory() {
    get("/ars") {
        call.respondText("Arsenal was the first club from the South of England to join The Football League, in 1893, and they reached the First Division in 1904. Relegated only once, in 1913, they continue the longest streak in the top division, and have won the second-most top-flight matches in English football history.")
    }
}

fun Route.getAllArsPlayers() {
    get("/ars/players") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Arsenal" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllArsForwards() {
    get("/ars/players/forwards") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Arsenal" }.filter { it.position == "forward" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllArsMidfielder() {
    get("/ars/players/midfielders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Arsenal" }.filter { it.position == "midfielder" }
            .let { players -> call.respond(players) }
    }
}

fun Route.getAllArsDefenders() {
    get("/ars/players/defenders") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Arsenal" }.filter { it.position == "defender" }
            .let { players -> call.respond(players) }
    }
}
fun Route.getAllArsGoalkeepers() {
    get("/ars/players/goalkeepers") {
        DAOFacadeImpl().getAllPlayers().filter { it.team == "Arsenal" }.filter { it.position == "goalkeeper" }
            .let { players -> call.respond(players) }
    }
}