package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@ToString
@RequiredArgsConstructor
final class RequireBaseInfo {
    private final String name;
    private final String email;

    private final PoweredBy poweredBy;

    static RequireBaseInfo of(String name, String email, String poweredBy, String poweredByIcon) {
        return new RequireBaseInfo(name, email
                    , PoweredBy.createOrEmpty( poweredBy, poweredByIcon)
        );
    }
}
