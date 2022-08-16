package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.*;

@Getter
@ToString
@Builder(builderClassName = "DataStoreConcretelyBuilder", buildMethodName = "create")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class DataStore {
    private final String logFile;
    private final int initConns;
    private final int maxConns;
    private final int connUsageLimit;
    private final String logLevel;

    static final DataStore empty = new DataStore(""
            , Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE
            , "");

    static DataStoreBuilder useDataStore(boolean useDataStore){
        if(!useDataStore) {
            return () -> empty;
        }
        return DataStore.builder();
    }

    /**
     * lombok에서 자동으로 생성된 Builder객체에
     * DataStoreBuilder 인터페이스(마커인터페이스) 적용해서,
     * useDataStore가 false로 설정되는 경우,
     * 외부에서 값을 설정해도 empty값을 리턴하도록 구성
     *
     * 만약, useDataStore가 true로 설정되면, lombok에서 생성된
     * DataStoreConcretelyBuilder가 동작해서 DataStore 각 필드 값을 설정하도록 구성됨
     */
    static final class DataStoreConcretelyBuilder implements DataStoreBuilder{}
}
