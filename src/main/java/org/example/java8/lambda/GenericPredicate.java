//2023-01-11
package org.example.java8.lambda;

// Generic
@FunctionalInterface
public interface GenericPredicate<T> {

    boolean test(T t);
}
