package com.siemens.pl.it.rest;/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 10:43 AM 
 */

import com.siemens.pl.it.rest.models.Quote;
import com.siemens.pl.it.rest.services.QuoteService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;


@Path("quotes")
public class QuoteResource {

  private final QuoteService service;

  public QuoteResource() {
    service = new QuoteService();
  }

  @GET
//  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON})
  public Collection<Quote> quotes() {
    return service.getAllQuotes();
  }

  @GET
  @Path("/{quoteId}/{revision}")
//  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON})
  public Quote quote(@PathParam("quoteId") final String quoteId,
                     @PathParam("revision") final String revision) {
    return service.quote(quoteId, revision);

  }


}