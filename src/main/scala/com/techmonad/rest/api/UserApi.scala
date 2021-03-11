package com.techmonad.rest.api

import akka.http.scaladsl.server.Directives._
import com.techmonad.rest.json.JsonHelper._
import com.techmonad.rest.{User, UserService}

trait UserApi {


  val userRoutes = {
    pathPrefix("api" / "user") {
      path("getAll") {
        get {
          val users = UserService.getAll()
          complete(write(users))
        }
      } ~
        path("create") {
          post {
            entity(as[String]) { requestJson =>
              val user = parse(requestJson).extract[User]
              val isCreated = UserService.create(user)
              if (isCreated) {
                complete("User is created successfully")
              } else {
                complete("User is already exist")
              }
            }
          }
        } ~ path("delete") {
        delete {
          parameters("email") { email =>
            val isDeleted = UserService.delete(email)
            if (isDeleted) {
              complete("User is deleted successfully")
            } else {
              complete("User dose not exist")
            }
          }
        }
      }

    }
  }

}
