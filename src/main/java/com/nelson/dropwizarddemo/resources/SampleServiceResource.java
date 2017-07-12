package com.nelson.dropwizarddemo.resources;

import com.codahale.metrics.annotation.Timed;
import com.nelson.dropwizarddemo.api.Saying;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;
/**
 * Created by ngome on 10/07/2017.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SampleServiceResource {
  private final String template;
  private final String defaultName;
  private final AtomicLong counter;

  public SampleServiceResource(String template, String defaultName) {
    this.template = template;
    this.defaultName = defaultName;
    this.counter = new AtomicLong();
  }

  @GET
  @Timed
  public Saying sayHello(@QueryParam("name") Optional<String> name) {

    final String value;
    if  (!name.isPresent() || !name.get().equalsIgnoreCase("nelson"))
      value = "You're not my master!!";
    else
      value = String.format(template, name.get());

    return new Saying(counter.incrementAndGet(), value);
  }
  /*@GET
  public String sayHello(@PathParam("name") String name) {
    return "Hello, " + name + "!";
  }*/
}
