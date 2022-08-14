package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
final class DefaultFields<T> {
    private final List<T> fields;

    boolean is(T... args) {
        return fields.equals(List.of(args));
    }

    static <T> DefaultFields<T> defaultFields(T... fields) {
        return new DefaultFields<>(List.of(fields));
    }
}
