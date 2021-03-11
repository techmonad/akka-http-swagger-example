package com.techmonad.rest

object UserService {

  private var users = List[User](User("Bob", "bob@gmail.com", "HYD"))

  def getAll(): List[User] = {
    users
  }

  def create(user: User): Boolean = {
    if (isExist(user.email)) {
      users = users :+ user
      true
    } else {
      false
    }
  }

  private def isExist(email: String): Boolean = {
    users.find(_.email == email).isDefined
  }

  def delete(email: String): Boolean = {
    if (isExist(email)) {
      users = users.filterNot(_.email == email)
      true
    } else {
      false
    }
  }

}


case class User(name: String, email: String, city: String)
