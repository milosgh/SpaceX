package com.example.spacexpastlaunches.commons.ioc.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by milospesic on 10/05/19.
 */


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
