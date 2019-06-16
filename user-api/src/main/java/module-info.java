module user.api {
  requires jackson.annotations;
  requires com.fasterxml.jackson.databind;
  requires org.immutables.value;
  requires common.api;
  exports com.mz.user.dto;
  exports com.mz.user.message.command;
  exports com.mz.user.message;
  exports com.mz.user.message.event;
  exports com.mz.user.topics;
}
