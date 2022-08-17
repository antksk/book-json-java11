package com.github.antksk.book.json._01_biz_and_small.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

class DefaultTemplateTest {

    @DisplayName("JSON형식으로 값이 없어, 기본값([])으로 대치 한 경우")
    @Test
    void test0() {
        String defaultListTemplate = null;
        String defaultFileTemplate = null;

        Set<String> defaultTemplates = Optional.ofNullable(defaultListTemplate) // defaultListTemplate 값이 설정되어 있으면,
                .map(s -> s.split(","))                                   // "," 기준으로 split 하고,
                .map(Set::of)                                                    // String[] 에서 중복을 제거하여 불변Set으로 변경
                .orElse(Optional.ofNullable(defaultFileTemplate)   // 혹은, defaultFileTemplate 설정된 경우라면
                        .map(Set::of)                               // defaultFileTemplate 값을 첫번째 요소에 넣고,
                        .orElse(Collections.emptySet()));           // 혹은, defaultListTemplate 값이 없다면, 비어 있는 불변 Set을 리턴

        System.out.println(defaultTemplates);
    }

    @DisplayName("DefaultTemplate 클래스를 정의하여, forEach 쉽게 사용하기")
    @Test
    void test1() {
        String defaultListTemplate = "a.html,c.htm,aaa.html,aa.html";
        String defaultFileTemplate = null;

        DefaultTemplate.optional(defaultListTemplate, defaultFileTemplate)
                .forEach(System.out::println);
    }













}