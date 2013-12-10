package com.siemens.pl.it.rest;/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 10:43 AM 
 */

import com.siemens.pl.it.rest.models.Quote;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;


@Path("quotes")
public class QuoteResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<Quote> quotes() {
    return getAllQuotes();
  }

  @GET
  @Path("/{quoteId}/{revision}")
  @Produces(MediaType.APPLICATION_JSON)
  public Quote quote(@PathParam("quoteId") String quoteId, @PathParam("revision") String revision) {
    return new Quote();
  }

  protected Collection<Quote> getAllQuotes() {
    ArrayList<Quote> quotes = new ArrayList<Quote>();

    return quotes;

  }

}