package com.siemens.pl.it.rest.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 11:01 AM
 */
@XmlType(namespace = "http://models.rest.it.pl.siemens.com/quotes")
@XmlRootElement
public class QuoteItem {

  private String sku;
  private int quantity;
  private double licenseListPrice;
  private Date mesExpirationDate;

  public double getLicenseListPrice() {
    return licenseListPrice;
  }

  public void setLicenseListPrice(double licenseListPrice) {
    this.licenseListPrice = licenseListPrice;
  }

  public Date getMesExpirationDate() {
    return mesExpirationDate;
  }

  public void setMesExpirationDate(Date mesExpirationDate) {
    this.mesExpirationDate = mesExpirationDate;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }
}
