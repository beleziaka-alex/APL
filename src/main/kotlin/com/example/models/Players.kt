package com.example.models

import kotlinx.serialization.Serializable
import org.h2.table.Table
import org.jetbrains.exposed.sql.*

@Serializable
data class Player(
    val id: Int = 0,
    val name: String,
    val team: String,
    val number: Int,
    val skill: Int,
    val position: String,
    val country: String
)

object Players : org.jetbrains.exposed.sql.Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 256)
    val team = varchar("team", 256)
    val number = integer("number")
    val skill = integer("skill")
    val position = varchar("position", 256)
    val country = varchar("country", 128)

    override val primaryKey = PrimaryKey(id)
}