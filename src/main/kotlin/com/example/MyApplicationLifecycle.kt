package com.example

import io.quarkus.arc.ArcContainer
import io.vertx.core.Vertx
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.Destroyed
import javax.enterprise.context.Initialized
import javax.enterprise.event.Observes


@ApplicationScoped
class MyApplicationLifecycle {
    private val users: MutableMap<String, String> = HashMap<String, String>()

    fun init(@Observes @Initialized(ApplicationScoped::class) init: Any?) {
//        var  c = init as ArcContainer

        println("*".repeat(40))
        println(init!!::class)
        println(init)
//        println(c.beanManager().getBeans("io.vertx.core.Vertx"))
        println("*".repeat(40))
        users["cdi"] = "CDI"
    }

    fun destroy(@Observes @Destroyed(ApplicationScoped::class) init: Any?) {
        users.clear()
    }
}