package com.example

import io.quarkus.runtime.StartupEvent
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.Initialized
import javax.enterprise.event.Observes


@ApplicationScoped
class MyApplicationLifecycle {
//    private val users: MutableMap<String, String> = HashMap<String, String>()

    fun onStart(@Observes ev: StartupEvent?, tcpServer: Server) {
        // For singleton injection is enough
        // For @ApplicationScoped beans a client proxy is injected and so we need to invoke some method to force bean instantiation
        tcpServer.init()
    }
//    fun init(@Observes @Initialized(ApplicationScoped::class) init: Any?) {
////        var  c = init as ArcContainer
//
//        println("*".repeat(40))
//        println(init!!::class)
//        println(init)
////        println(c.beanManager().getBeans("io.vertx.core.Vertx"))
//        println("*".repeat(40))
//        users["cdi"] = "CDI"
//    }
//
//    fun destroy(@Observes @Destroyed(ApplicationScoped::class) init: Any?) {
//        users.clear()
//    }
}