package com.mz.reactivedemo.common.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchTest {

    @Test
    void build() {

        List<String> list = Arrays.asList("list");

        String result = Match.<String>match(list)
            .when(List.class, type -> "List")
            .when(ArrayList.class, type -> "ArrayList")
            .when(String.class, type -> "String")
            .when(List.class, type -> "List2")
            .get().get();

        assertTrue(result.equals("List"));
    }

    @Test
    void orElseGet() {
        List<String> list = Arrays.asList("list");

        String result = Match.<String>match(list)
            .when(String.class, type -> "String")
            .when(Map.class, type -> "List2")
            .orElseGet(() -> "orElseGet");

        assertTrue(result.equals("orElseGet"));
    }
}
