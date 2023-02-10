package com.example.routing

import com.example.dao.DAOFacade
import com.example.dao.DAOFacadeImpl
import com.example.models.Player
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val dao: DAOFacade = DAOFacadeImpl()
fun Route.homePage() {
    get {
        call.respondText("Welcome to homepage")
    }
}

fun Route.getAllPlayers() {
    get("/players") {
        val players = DAOFacadeImpl().getAllPlayers()
        if (players.isNotEmpty()) {
            call.respond(players)
        } else {
            call.respondText("Players not found", status = HttpStatusCode.BadRequest)
        }
    }
}

fun Route.getPlayer() {
    get("/players/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val player = DAOFacadeImpl().getPlayer(id) ?: return@get call.respondText(
            "Not found player with id $id",
            status = HttpStatusCode.NotFound
        )
        call.respond(player)
    }
}

fun Route.addNewPlayer() {
    post("players") {
        val player = call.receive<Player>()
        dao.addNewPlayer(player.name, player.team, player.number, player.skill, player.position, player.country)
        call.respondText("A new player was stored correctly")
    }
}

fun Route.deletePlayer() {
    delete("/players/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText("Missing id")
        val player = DAOFacadeImpl().getPlayer(id) ?: return@delete call.respondText("Not found player with id $id")
        DAOFacadeImpl().deletePlayers(id)
        call.respondText("Player ${player.name} was deleted correctly")
    }
}