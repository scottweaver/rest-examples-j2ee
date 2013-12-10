package com.siemens.pl.it.rest.client;

import com.siemens.pl.it.rest.models.Quote;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Collection;
import static siemens.plm.it.util.strings.StringsUtil.*;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 2:54 PM
 */
public class QuoteClient {

  private Client client;
  private final WebTarget target;

  public QuoteClient() {
    this.client = ClientBuilder.newClient();
    target = client.target("http://localhost:8080/webapi");
  }

  public Collection<Quote> getAllQuotes()  throws Exception
  {

    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(invoke("quotes"), new TypeReference<Collection<Quote>>() {});
  }

  public Quote getQuote(String id, String rev) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(invoke(printf("quotes/{0}/{1}", id, rev)), new TypeReference<Quote>() {});
  }

  protected String invoke(String path)  {
    WebTarget quotesTarget = target.path(path);
    Invocation.Builder builder = quotesTarget.request();
    Response response = builder.get();
    String entity = response.readEntity(String.class);
    System.out.println(entity);
    return entity;
  }
}
