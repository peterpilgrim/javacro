package uk.co.xenonique.javacro

import javax.annotation.{PreDestroy, PostConstruct}
import javax.ejb.{Startup, Singleton}

/**
 * The type PredictorService
 *
 * @author Peter Pilgrim
 */

@Singleton
@Startup
class PredictorService {
  @PostConstruct def acquireResource {
    println(this.getClass.getSimpleName + "#acquireResource()")
  }

  @PreDestroy def releaseResource {
    println(this.getClass.getSimpleName + "#releaseResource()")
  }

  def configuredAllServices() = List("Split", "Rijeka")
}


/**
 * The type FastService
 *
 * @author Peter Pilgrim
 */
@Singleton
@Startup
class FastService {
  @PostConstruct def acquireResource {
    println(this.getClass.getSimpleName + "#acquireResource()")
  }

  @PreDestroy def releaseResource {
    println(this.getClass.getSimpleName + "#releaseResource()")
  }

  def configuredAllServices() = List("Porec", "Zagreb")
}
