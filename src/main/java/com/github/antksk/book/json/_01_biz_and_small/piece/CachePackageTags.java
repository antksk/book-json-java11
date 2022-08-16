package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static com.github.antksk.book.json._01_biz_and_small.piece.CachePackageTag.createOrEmpty;
import static com.github.antksk.book.json._01_biz_and_small.piece.CachePackageTag.rangeCondition;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CachePackageTags {
    private final CachePackageTag track;
    private final CachePackageTag store;
    private final CachePackageTag refresh;

    static CachePackageTags optional(int track, int store, int refresh){
        return new CachePackageTags(
                createOrEmpty(rangeCondition(0, 100), track),
                createOrEmpty(rangeCondition(-1, 200), store),
                createOrEmpty(rangeCondition(0, 10000), refresh)
        );
    }

    boolean isStoreUnlimited(){
        return store.getCache() == -1;
    }
}
