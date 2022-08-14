package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Optional;

import static com.github.antksk.book.json._01_biz_and_small.piece.DefaultFields.defaultFields;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class PoweredBy {
    private final String poweredBy;
    private final String poweredByIcon;

    public static final String EMPTY = "";
    static final PoweredBy EMPTY_POWERED_BY = new PoweredBy(EMPTY, EMPTY);

    private static final DefaultFields defaultFields = defaultFields(EMPTY, EMPTY);

    static String getOrEmpty(String str){
        return Optional.ofNullable(str)
                .orElse(EMPTY);
    }
    static PoweredBy createOrEmpty(String poweredBy, String poweredByIcon){
        if(defaultFields.is(poweredBy, getOrEmpty(poweredByIcon))) {
            return EMPTY_POWERED_BY;
        }
        return new PoweredBy(poweredBy, getOrEmpty(poweredByIcon));
    }
}
