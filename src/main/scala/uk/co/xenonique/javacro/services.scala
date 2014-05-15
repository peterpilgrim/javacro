/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

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
