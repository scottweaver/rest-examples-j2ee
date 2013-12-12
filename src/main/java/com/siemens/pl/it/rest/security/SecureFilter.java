package com.siemens.pl.it.rest.security;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import static siemens.plm.it.util.strings.StringsUtil.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 11:06 AM
 */

@Provider
@Secured
public class SecureFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext containerRequestContext) throws IOException {
//    System.out.println("***** SECURED SERVICE ENCOUNTERED! *****");
    String secuirtyToken =containerRequestContext.getHeaderString("Security-Token");
    System.out.println("***** SECURED SERVICE ENCOUNTERED! *****");
    System.out.println(printf("***** Security Token {0} *****", secuirtyToken ));
    if(secuirtyToken == null) {
      containerRequestContext.abortWith(Response
              .status(Response.Status.UNAUTHORIZED)
              .entity("User cannot access the resource.  No security found.")
              .build());
    }
  }
}