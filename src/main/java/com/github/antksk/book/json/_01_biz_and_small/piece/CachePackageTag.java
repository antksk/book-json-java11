package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Predicate;

@ToString
@RequiredArgsConstructor
final class CachePackageTag {
    @Getter
    private final int cache;

    private static final CachePackageTag empty = new CachePackageTag(Integer.MIN_VALUE);

    static CachePackageTag createOrEmpty(Predicate<Integer> range, int cache){
        if(!range.test(cache)){
            return empty;
        }
        return new CachePackageTag(cache);
    }

    static Predicate<Integer> lowerRange(final int lower){
        return (c) -> lower <= c;
    }
    static Predicate<Integer> higherRange(final int higher){
        return (c) -> higher >= c;
    }

    static Predicate<Integer> rangeCondition(final int lower, final int higher){
        return lowerRange(lower).and(higherRange(higher));
    }
}
