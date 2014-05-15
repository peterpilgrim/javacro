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

import scala.collection.immutable.List
import javax.ws.rs.core.MediaType
import javax.ws.rs.{Produces, GET, Path}
import javax.annotation.{PreDestroy, PostConstruct}
import scala.beans.BeanProperty

/**
 * The type RestfulBookService
 *
 * @author Peter Pilgrim
 */
case class Book(author: String, title: String)

@Path("/books")
class RestfulBookService {

  private val products:List[Book] = List(
    new Book("Sir Arthur Dolan Coyle",
      "Sherlock Holmes and the Hounds of the Baskerville"),
    new Book("Dan Brown", "Da Vinci Code"),
    new Book("Charles Dickens", "Great Expectations"),
    new Book("Robert Louis Stevenson", "Treasure Island")
  )

  @GET
  @Produces(Array(MediaType.TEXT_PLAIN)) def getList: String = {
    val buf: StringBuffer = new StringBuffer
    for (b <- products) {
      buf.append(b.title)
      buf.append('\n')
    }
    return buf.toString
  }

  @PostConstruct def acquireResource {
    println(this.getClass.getSimpleName + "#acquireResource()")
  }

  @PreDestroy def releaseResource {
    println(this.getClass.getSimpleName + "#releaseResource()")
  }

}



