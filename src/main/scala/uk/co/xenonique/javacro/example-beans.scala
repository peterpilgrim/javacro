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

import javax.enterprise.context.{ApplicationScoped, SessionScoped, RequestScoped}
import javax.servlet.annotation.WebServlet
import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import java.io.PrintWriter
import java.util.Date
import javax.inject.Inject
import java.text.SimpleDateFormat

trait InfoHelper {
  val creationDate = new Date()
  def getInfo() = {
    val formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.S")

    "bean "+this.getClass.getName+"  instance = "+Integer.toHexString(this.hashCode()) +
    " creation date: " + formatter.format(creationDate)
  }
}
@RequestScoped
class RequestBean extends InfoHelper { }

@SessionScoped
class SessionBean extends InfoHelper with Serializable { }

@ApplicationScoped
class ApplicationBean extends InfoHelper { }


@WebServlet(urlPatterns =Array("/infoServlet"), name="InfoServlet" )
class InfoServlet extends HttpServlet {

  @Inject  var requestBean: RequestBean = _
  @Inject  var sessionBean: SessionBean = _
  @Inject  var applicationBean: ApplicationBean = _

  override def init(): Unit = {
    println(this.getClass.getSimpleName + "#init() called ")
  }

  override def doGet( request: HttpServletRequest, response: HttpServletResponse): Unit = {
    response.setContentType("text/plain")
    val pwriter: PrintWriter = response.getWriter
    pwriter.printf("This is the class `%s'\nThe date time is %s\n", this.getClass.getName, new Date)

    val list = List(requestBean, sessionBean, applicationBean)
    for { bean <- list} {
      pwriter.printf("report "+bean.getInfo()+"\n");
    }
  }
}
