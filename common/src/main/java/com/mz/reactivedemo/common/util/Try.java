package com.mz.reactivedemo.common.util;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Try<T> {

  abstract public boolean isSuccess();

  abstract public boolean isFailure();

  abstract public Optional<T> toOptional();

  abstract public <R> Try<R> map(FunctionThrowable<T, R> f);

  abstract public <R> Try<R> flatMap(FunctionThrowable<T, Try<R>> f);

  abstract public Try<T> onFailure(Consumer<Throwable> f);

  abstract public Try<T> onSuccess(Consumer<T> f);

  abstract public T getOrElse(Supplier<T> f);

  abstract public T get();

  static public <T> Try<T> of(SupplierThrowable<T> f) {
    try {
      Objects.requireNonNull(f);
      return new Success<>(f.get());
    } catch (Throwable error) {
      return new Failure<>(error);
    }
  }

  static public <T> Try<T> error(Throwable error) {
    return new Failure<>(error);
  }

  static public class Success<T> extends Try<T> {

    private final T result;

    private Success(T result) {
      this.result = result;
    }

    @Override
    public T get() {
      return this.result;
    }

    @Override
    public boolean isSuccess() {
      return true;
    }

    @Override
    public boolean isFailure() {
      return false;
    }

    @Override
    public Optional<T> toOptional() {
      return Optional.of(result);
    }

    @Override
    public <R> Try<R> map(FunctionThrowable<T, R> f) {
      try {
        Objects.requireNonNull(result);
        R resultMap = f.apply(result);
        Objects.requireNonNull(resultMap);
        return new Success<>(resultMap);
      } catch (Throwable error) {
        return new Failure<>(error);
      }
    }

    @Override
    public <R> Try<R> flatMap(FunctionThrowable<T, Try<R>> f) {
      try {
        Objects.requireNonNull(f);
        return f.apply(this.result);
      } catch (Throwable error) {
        return (Try<R>) this;
      }
    }

    @Override
    public Try<T> onFailure(Consumer<Throwable> f) {
      return this;
    }

    @Override
    public Try<T> onSuccess(Consumer<T> f) {
      Objects.requireNonNull(f);
      f.accept(result);
      return this;
    }

    @Override
    public T getOrElse(Supplier<T> f) {
      return result;
    }
  }

  static public class Failure<T> extends Try<T> {

    private final Throwable error;

    private Failure(Throwable error) {
      this.error = error;
    }

    public Throwable error() {
      return this.error;
    }

    @Override
    public boolean isSuccess() {
      return false;
    }

    @Override
    public boolean isFailure() {
      return true;
    }

    @Override
    public Optional<T> toOptional() {
      return Optional.empty();
    }

    @Override
    public <R> Try<R> map(FunctionThrowable<T, R> f) {
      return (Try<R>) this;
    }

    @Override
    public <R> Try<R> flatMap(FunctionThrowable<T, Try<R>> f) {
      return (Try<R>) this;
    }

    @Override
    public Try<T> onFailure(Consumer<Throwable> f) {
      Objects.requireNonNull(f);
      f.accept(error);
      return this;
    }

    @Override
    public Try<T> onSuccess(Consumer<T> f) {
      return this;
    }

    @Override
    public T getOrElse(Supplier<T> f) {
      return f.get();
    }

    @Override
    public T get() {
      throw new NoSuchElementException(error.getMessage());
    }
  }

  @FunctionalInterface
  public interface FunctionThrowable<T, R> {

    R apply(T t) throws Throwable;

  }

  @FunctionalInterface
  public interface SupplierThrowable<T> {

    T get() throws Throwable;

  }
}
