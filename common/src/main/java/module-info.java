module common {
  requires static common.api;
  requires static reactor.core;
  requires static spring.web;
  requires static spring.webflux;
  requires static org.eclipse.collections.api;
  requires static org.eclipse.collections.impl;
  requires static org.immutables.value;
  requires static com.fasterxml.jackson.databind;
  requires static jackson.annotations;
  requires static java.annotation;
  requires static spring.jcl;
  exports com.mz.reactivedemo.common;
  exports com.mz.reactivedemo.common.aggregate;
  exports com.mz.reactivedemo.common.errors;
  exports com.mz.reactivedemo.common.service;
  exports com.mz.reactivedemo.common.service.impl;
  exports com.mz.reactivedemo.common.utils;
}
