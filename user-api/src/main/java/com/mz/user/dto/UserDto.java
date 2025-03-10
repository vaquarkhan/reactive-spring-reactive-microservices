package com.mz.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * Created by zemi on 16/01/2019.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableUserDto.class)
@JsonDeserialize(as = ImmutableUserDto.class)
public interface UserDto extends BasicDto {

  String lastName();

  String firstName();

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  Optional<String> shortenerId();

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  Optional<ContactInfoDto> contactInformation();

  static ImmutableUserDto.Builder builder() {
    return ImmutableUserDto.builder();
  }
}
