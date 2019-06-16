open module shortener.impl {
  requires common.persistence;
  requires common.api;
  requires common;
  requires shortener.api;
  requires spring.jcl;
  requires spring.context;
  requires reactor.core;
  requires spring.cloud.stream;
  requires java.validation;
  requires kafka.streams;
  requires user.api;
  requires spring.boot;
  requires spring.boot.autoconfigure;
  requires spring.data.commons;
  requires spring.data.mongodb;
  requires spring.kafka;
  requires spring.messaging;
  requires java.annotation;
  uses com.mz.reactivedemo.adapter.persistance.persistence.RepositoryActor;
}
