package com.siemens.pl.it.rest.security;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: Scott T Weaver
 * Time: 11:05 AM
 */

@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {
}
