package com.github.antksk.book.json._01_biz_and_small.piece;

interface DataStoreBuilder {
    default DataStoreBuilder logFile(String dataStoreLogFile) {
        return this;
    }

    default DataStoreBuilder initConns(int dataStoreInitConns) {
        return this;
    }

    default DataStoreBuilder maxConns(int dataStoreMaxConns) {
        return this;
    }

    default DataStoreBuilder connUsageLimit(int dataStoreConnUsageLimit) {
        return this;
    }

    default DataStoreBuilder logLevel(String dataStoreLogLevel) {
        return this;
    }

    DataStore create();
}
