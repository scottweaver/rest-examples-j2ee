package com.siemens.pl.it.rest;

import com.siemens.pl.it.rest.security.SecureFilter;
import com.sun.org.apache.xml.internal.utils.DefaultErrorHandler;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 1:24 PM
 */
public class Application extends ResourceConfig {

  public Application() {
    super(JacksonFeature.class, JacksonObjectMapper.class, DefaultErrorHandler.class);
    packages("com.siemens.pl.it.rest", "com.siemens.pl.it.rest.security");
//    register(SecureFilter.class);

  }
}
