package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class DataStoreTest {

    @DisplayName("useDataStore값이 false이면, 다른 값이 아무리 설정되어도 무조건 empty로 설정됨")
    @Test
    void test0() {
        DataStore empty0 = DataStore.useDataStore(false)
                .create();

        assertThat(DataStore.empty)
                .isEqualTo(empty0);

        DataStore empty1 = DataStore.useDataStore(false)
                .connUsageLimit(0)
                .logFile("log")
                .logLevel("test")
                .initConns(0)
                .maxConns(100)
                .create();

        assertThat(DataStore.empty)
                .isEqualTo(empty1);
    }

    @DisplayName("useDataStore값이 true이면, DataStore값이 설정됨")
    @Test
    void test1() {
        DataStore dataStore = DataStore.useDataStore(true)
                .logFile("myLogFile.log")
                .connUsageLimit(0)
                .create();

        log.debug("result : " +
                "\n - logFile : {}" +
                "\n - connUsageLimit : {}"
                , dataStore.getLogFile()
                , dataStore.getConnUsageLimit()
        );

        assertThat(dataStore.getLogFile()).isEqualTo("myLogFile.log");
        assertThat(dataStore.getConnUsageLimit()).isEqualTo(0);
    }
}