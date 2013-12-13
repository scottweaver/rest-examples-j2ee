package com.siemens.pl.it.rest.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 10:43 AM
 */
@XmlType(namespace = "http://models.rest.it.pl.siemens.com/quotes")
@XmlRootElement
public class Quote {

  private String quoteId;
  private String revision;
  private String name;

  private Collection<QuoteItem> quoteItems;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(String quoteId) {
    this.quoteId = quoteId;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public Collection<QuoteItem> getQuoteItems() {
    return quoteItems;
  }

  public void setQuoteItems(Collection<QuoteItem> quoteItems) {
    this.quoteItems = quoteItems;
  }

}
