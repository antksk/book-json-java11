package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
@ToString
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class DefaultTemplate implements Iterable<String> {

    private final Set<String> templates;

    static DefaultTemplate optional(String defaultListTemplate, String defaultFileTemplate) {
        Set<String> templates = Optional.ofNullable(defaultListTemplate) // defaultListTemplate 값이 설정되어 있으면,
                .map(s -> s.split(","))                                   // "," 기준으로 split 하고,
                .map(Set::of)                                                    // String[] 에서 중복을 제거하여 불변Set으로 변경
                .orElse(Optional.ofNullable(defaultFileTemplate)   // 혹은, defaultFileTemplate 설정된 경우라면
                        .map(Set::of)                               // defaultFileTemplate 값을 첫번째 요소에 넣고,
                        .orElse(Collections.emptySet()));
        return new DefaultTemplate(templates);
    }

    @Override
    public Iterator<String> iterator() {
        return templates.iterator();
    }
}
