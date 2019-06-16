module common.persistence {
  requires akka.actor;
  requires akka.persistence;
  requires common.api;
  requires org.eclipse.collections.api;
  requires common;
  requires reactor.core;
  requires spring.jcl;
  requires spring.beans;
  requires spring.context;
  exports com.mz.reactivedemo.adapter.persistance.persistence;
}
