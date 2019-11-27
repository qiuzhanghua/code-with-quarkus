package com.example

import io.vertx.core.Vertx
import javax.annotation.PostConstruct
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
@ApplicationScoped
open class Server {
    @Inject
    @field: Default
    lateinit var vertx: Vertx

    init {
        println("in static init")
    }

    @PostConstruct
    open fun init() {
        println("init")
        var server = vertx.createNetServer()
        server.listen(1234, "localhost") { res ->
            if (res.succeeded()) {
                println("Server is now listening!")
            } else {
                println("Failed to bind!")
            }
        }
    }
}