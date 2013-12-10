package com.siemens.pl.it.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 2:42 PM
 */
@Provider
public class JacksonObjectMapper implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;



    public JacksonObjectMapper() {
      defaultObjectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {

        return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
      ObjectMapper result = new ObjectMapper();
      result.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);

      return result;
    }

}