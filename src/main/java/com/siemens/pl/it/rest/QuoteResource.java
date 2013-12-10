package com.siemens.pl.it.rest;/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 10:43 AM 
 */

import com.siemens.pl.it.rest.models.Quote;
import com.siemens.pl.it.rest.models.QuoteItem;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


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
    quotes.add(newQuote("10000", "1", "New quote 1",
            newQuoteItem("A001", 1, 200.00, new Date())));
    return quotes;

  }

  protected Quote newQuote(String id, String rev, String name, QuoteItem...  items)  {
    Quote quote = new Quote();
    quote.setQuoteId(id);
    quote.setRevision(rev);
    quote.setName(name);
    quote.setQuoteItems(Arrays.asList(items));
    return quote;
  }

  protected QuoteItem newQuoteItem(String sku, int qty, double listPrice, Date expDate) {
    QuoteItem quoteItem = new QuoteItem();
    quoteItem.setSku(sku);
    quoteItem.setQuantity(qty);
    quoteItem.setLicenseListPrice(listPrice);
    quoteItem.setMesExpirationDate(expDate);
    return quoteItem;
  }

}