package com.siemens.pl.it.rest.services;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.siemens.pl.it.rest.models.Quote;
import com.siemens.pl.it.rest.models.QuoteItem;

import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 10:29 AM
 */
public class QuoteService {
  public Quote quote(final String quoteId,
                     final String revision) {
    Collection<Quote> quotesFound =  Collections2.filter(getAllQuotes(), new Predicate<Quote>() {
      @Override
      public boolean apply(Quote quote) {
        return quote.getQuoteId().equals(quoteId) && quote.getRevision().equals(revision);
      }
    });

    if(!quotesFound.isEmpty()) {
      return quotesFound.iterator().next();
    }
    else {
      // Use 400 if it is the user's fault, 500 if it is yours.
      throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
              .entity("Quote id/rev not found")
              .type(MediaType.APPLICATION_JSON_TYPE).build());
    }

  }

  public Collection<Quote> getAllQuotes() {
    ArrayList<Quote> quotes = new ArrayList<Quote>();
    quotes.add(newQuote("10000", "1", "New quote 1",
            newQuoteItem("A001", 1, 200.00, new Date())));

    quotes.add(newQuote("20000", "1", "New quote 2",
            newQuoteItem("A002", 5, 500.00, new Date())));

    quotes.add(newQuote("30000", "1", "New quote 3",
            newQuoteItem("UG10100", 1, 700.00, new Date()),
            newQuoteItem("A001", 1, 200.00, new Date())
    ));
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
