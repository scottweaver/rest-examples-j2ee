package com.siemens.pl.it.rest.client;

import com.siemens.pl.it.rest.models.Quote;
import com.siemens.pl.it.rest.models.QuoteItem;
import org.joda.time.DateTime;
import org.junit.Test;
import static junit.framework.Assert.*;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 3:05 PM
 */
public class TestQuoteClient {

  @Test
  public void test_retrieving_all_quotes() throws Exception{
    QuoteClient client = new QuoteClient();
    Collection<Quote> quotes = client.getAllQuotes();

    assertEquals(3, quotes.size());
  }


  @Test
  public void test_retrieving_a_single_quote() throws Exception{
    QuoteClient client = new QuoteClient();
    Quote quote = client.getQuote("30000", "1");

    assertNotNull(quote);
    assertEquals("30000", quote.getQuoteId());
    assertEquals("1", quote.getRevision());
    assertEquals(2, quote.getQuoteItems().size());

    QuoteItem qi1 = quote.getQuoteItems().iterator().next();
    assertEquals("UG10100", qi1.getSku());
    assertEquals(1, qi1.getQuantity());
    DateTime expDate = new DateTime(qi1.getMesExpirationDate());
    assertEquals(12, expDate.getMonthOfYear());
    assertEquals(2013, expDate.getYear());
  }
}
