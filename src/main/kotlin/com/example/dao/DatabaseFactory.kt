package com.example.dao

import com.example.models.Players
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val config = HikariConfig().apply {
            jdbcUrl = "jdbc:mysql://localhost/APL"
            driverClassName = "com.mysql.cj.jdbc.Driver"
            username = "root"
            password = "123456789"
            maximumPoolSize = 10
        }
        val dataSource = HikariDataSource(config)
        val database = Database.connect(dataSource)
        transaction(database) {
            SchemaUtils.create(Players)

        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T = newSuspendedTransaction(Dispatchers.IO) { block() }
}