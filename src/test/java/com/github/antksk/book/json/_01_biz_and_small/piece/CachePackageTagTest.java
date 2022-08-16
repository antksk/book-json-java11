package com.github.antksk.book.json._01_biz_and_small.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static com.github.antksk.book.json._01_biz_and_small.piece.CachePackageTag.*;
import static com.github.antksk.book.json._01_biz_and_small.piece.CachePackageTag.rangeCondition;
import static org.assertj.core.api.Assertions.assertThat;

class CachePackageTagTest {

    @DisplayName("0 ~ 100까지만 등록하도록 범위 제한하여, CachePackageTag 생성")
    @Test
    void test0() {
        Predicate<Integer> condition = rangeCondition(0, 100);
        assertThat(createOrEmpty(condition, 10).getCache()).isEqualTo(10);
        assertThat(createOrEmpty(condition, -1).getCache()).isEqualTo(Integer.MIN_VALUE);
        assertThat(createOrEmpty(condition, 1000).getCache()).isEqualTo(Integer.MIN_VALUE);
    }

    @DisplayName("cachePackageTagsTrack에 범위가 0 ~ 100 까지")
    @Test
    void test1() {
        createOrEmpty(rangeCondition(0, 100), -1)
                .getCache();
    }
}