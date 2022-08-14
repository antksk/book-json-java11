package com.github.antksk.book.json._01_biz_and_small.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.antksk.book.json._01_biz_and_small.piece.DefaultFields.defaultFields;
import static org.assertj.core.api.Assertions.assertThat;

class DefaultFieldsTest {

    @DisplayName("[거짓] 기본 필드 값보다 비교하려는 데이터가 많은 경우")
    @Test
    void test0() {
        final DefaultFields<Object> emptyDefaultFields = defaultFields();
        assertThat(emptyDefaultFields.is(0,0)).isFalse();

        assertThat(defaultFields(0).is(-1, 0)).isFalse();
        assertThat(defaultFields(0).is(0, -1)).isFalse();

        assertThat(defaultFields(0,1,2).is(-1, 0)).isFalse();
    }

    @DisplayName("[거짓] 기본 필드 값과 비교하려는 데이터의 순서가 다른 경우")
    @Test
    void test1() {
        var defaultFields = defaultFields(0, -1);
        assertThat(defaultFields.is(-1, 0)).isFalse();
    }

    @DisplayName("[거짓] 기본 필드 문자열 값과 비교하려는 데이터가 다른 경우")
    @Test
    void test2() {
        var defaultFields = defaultFields("", "");
        assertThat(defaultFields.is(" ", " abc ")).isFalse();
    }

}