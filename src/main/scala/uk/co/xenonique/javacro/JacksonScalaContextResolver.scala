package uk.co.xenonique.javacro

import javax.ws.rs.ext.Provider
import javax.ws.rs.{Produces, Consumes,Path}
import javax.ws.rs.core.MediaType
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import javax.inject.Singleton
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.annotation.JsonInclude.Include

/**
 * The type JacksonScalaContextResolver
 *
 * @author Peter Pilgrim
 */
@Singleton
@Provider
@Consumes(
  Array(MediaType.APPLICATION_JSON,
    "application/*+json", "text/json"))
@Produces(
  Array(MediaType.APPLICATION_JSON,
    "application/*+json", "text/json"))
class JacksonScalaContextResolver extends JacksonJaxbJsonProvider(
  JacksonScalaContextResolver.getObjectMapper,
  JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS)



object JacksonScalaContextResolver {
  def getObjectMapper: ObjectMapper = {
    val mapper = new ObjectMapper with ScalaObjectMapper
    mapper.registerModule(new DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper
  }
}
