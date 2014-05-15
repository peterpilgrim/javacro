package uk.co.xenonique.javacro

import javax.ejb.{Singleton, Startup}
import javax.annotation.{PreDestroy, PostConstruct}

/**
 * The type User
 *
 * @author Peter Pilgrim
 */
case class User( loginName: String, firstName: String, lastName: String, secretCode: Int )

@Startup
@Singleton
class UserRegistry {

  private var registeredUsers = Map.empty[String,User]

  def addUser( user: User ):Unit = {
    registeredUsers += ( user.loginName -> user )
  }

  def removeUser( user: User): Unit = {
    registeredUsers -= user.loginName
  }

  def findUser( loginName: String ): Option[User] = {
    registeredUsers.get(loginName)
  }

  def getUsers(): List[User] = {
    registeredUsers.toSeq.sortWith ( _._1 < _._1 ) map ( _._2) toList
  }

  @PostConstruct def acquireResource {
    println(this.getClass.getSimpleName + "#acquireResource()")

    addUser( User( "jobs", "Steve", "Jobs", 1955 ))
    addUser( User( "mandela", "Nelson", "Mandela", 1918 ))
    addUser( User( "ordersky", "Martin", "Odersky", 1958 ))
    addUser( User( "giggs", "Ryan", "Giggs", 1973  ))
    addUser( User( "gosling", "James", "Gosling", 1955 ))
  }

  @PreDestroy def releaseResource {
    println(this.getClass.getSimpleName + "#releaseResource()")
  }


}
