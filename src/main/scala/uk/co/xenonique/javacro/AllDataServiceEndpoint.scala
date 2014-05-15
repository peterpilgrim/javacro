package uk.co.xenonique.javacro

import javax.ws.rs.{Produces, GET, Path}
import javax.ws.rs.core.{MediaType, Response, Context}
import javax.servlet.http.HttpServletRequest
import javax.json.{JsonObject, Json}
import javax.ejb.EJB

/**
 * The type AllDataServiceEndpoint
 *
 * @author Peter Pilgrim
 */
@Path("/alldata")
class AllDataServiceEndpoint {
  @EJB var fastService: FastService = _
  @EJB var predictorService: PredictorService = _
  @Context var request: HttpServletRequest = _

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def listServices = {
    val listServices =
      (fastService.configuredAllServices ++
        predictorService.configuredAllServices) map {
      makeElement( _ )
    }

    val builder1 = Json.createObjectBuilder()
    builder1.add("country", "Croatia")

    val builder2 = Json.createArrayBuilder()
    for ( e <- listServices) {
      builder2.add( e )
    }
    builder1.add("cities", builder2.build())

    Response.ok(builder1.build(), MediaType.APPLICATION_JSON).build
  }

  def makeElement( value: String ): JsonObject = {
      Json.createObjectBuilder().add( "city", value ).build()
  }
}


