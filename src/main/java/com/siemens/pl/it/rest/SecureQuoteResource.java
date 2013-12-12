package com.siemens.pl.it.rest;

import com.siemens.pl.it.rest.models.Quote;
import com.siemens.pl.it.rest.security.Secured;
import com.siemens.pl.it.rest.services.QuoteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 10:45 AM
 */
@Path("secure-quotes")
public class SecureQuoteResource {

  private final QuoteService service;


   public SecureQuoteResource() {
    service = new QuoteService();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Secured
  public Collection<Quote> quotes() {
    return service.getAllQuotes();
  }

  @GET
  @Path("/{quoteId}/{revision}")
  @Produces(MediaType.APPLICATION_JSON)
  @Secured
  public Quote quote(@PathParam("quoteId") final String quoteId,
                     @PathParam("revision") final String revision) {
    return service.quote(quoteId, revision);

  }

}
