package com.techmonad.rest

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import com.techmonad.rest.api.UserApi


object HttpServer extends App with UserApi {

  implicit val system = ActorSystem(Behaviors.empty, "UserApiSystem")

  implicit val executionContext = system.executionContext

  val bindingFuture = Http().newServerAt("localhost", 9090).bind(userRoutes)


}
