# quarkus with kotlin and vertx


https://github.com/quarkusio/quarkus/issues/5799  Closed!

Why init and @PostConstruct don't work?

```kotlin
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
```
