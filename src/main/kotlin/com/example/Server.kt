package com.example

import io.vertx.core.Vertx
import javax.annotation.PostConstruct
import javax.ejb.Startup
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.Destroyed
import javax.enterprise.context.Initialized
import javax.enterprise.event.Observes
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
//@Startup
@ApplicationScoped
open class Server {

    @Inject
    @field: Default
    lateinit var vertx: Vertx

    init {
        println("in static init")
    }

    open fun init() {
        println("init")
        vertx.createHttpServer()
                .requestHandler { req ->
                    req.response().end("Hello!")
                }
                .listen(9090)
        var server = vertx.createNetServer()
        server.connectHandler { socket ->
            socket.handler { buffer ->
                println("I received some bytes: ${buffer.length()}")
            }
            socket.closeHandler { _ ->
                println("The socket has been closed")
            }
        }
        server.listen(9999, "0.0.0.0") { res ->
            if (res.succeeded()) {
                println("Server is now listening!")
            } else {
                println("Failed to bind!")
            }
        }
    }


//    open fun init2(@Observes @Initialized(ApplicationScoped::class) init: Any) {
//        println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
//        println(init.toString())
//    }
//
//        open fun destroy(@Observes @Destroyed(ApplicationScoped::class) init: Any) {
//        println("#######################")
//    }
}