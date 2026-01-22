package org.cinema.debug.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/pod-info")
public class PodInformationResource {

  @ConfigProperty(name = "POD_NAME", defaultValue = "unknown")
  String podName;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getPodInfo() {
    return podName;
  }
}
