module shortener.api {
  requires com.fasterxml.jackson.databind;
  requires common.api;
  requires org.immutables.value;
  requires jackson.annotations;
  exports com.mz.reactivedemo.shortener.api.command;
  exports com.mz.reactivedemo.shortener.api.dto;
  exports com.mz.reactivedemo.shortener.api.event;
  exports com.mz.reactivedemo.shortener.api.topics;
}
