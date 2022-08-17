package com.github.antksk.book.json._01_biz_and_small.piece;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import static com.github.antksk.book.json._01_biz_and_small.piece.Etc.etc;

@Slf4j
@ToString
@RequiredArgsConstructor
public final class SmallPieceObject {
    private final RequireBaseInfo requireBaseInfo;
    private final DefaultTemplate defaultTemplate;
    private final CachePackageTags cachePackageTags;
    private final DataStore dataStore;
    private final Etc etc;

    @JsonCreator
    static SmallPieceObject forJson(
            // RequireBaseInfo
            @JsonProperty(value="name", required = true) String name,
            @JsonProperty(value="email", required = true) String email,
            // RequireBaseInfo > PoweredBy
            @JsonProperty(value="poweredBy", required = true) String poweredBy,
            @JsonProperty(value="poweredByIcon") String poweredByIcon,

            // DefaultTemplate
            @JsonProperty("defaultListTemplate") String defaultListTemplate,
            @JsonProperty("defaultFileTemplate") String defaultFileTemplate,

            // CachePackageTags
            @JsonProperty("cachePackageTagsTrack") int track,
            @JsonProperty("cachePackageTagsStore") int store,
            @JsonProperty("cachePackageTagsRefresh") int refresh,

            // DataStore
            @JsonProperty("useDataStore") boolean useDataStore,
            @JsonProperty("dataStoreLogFile") String logFile,
            @JsonProperty("dataStoreInitConns") int initConnection,
            @JsonProperty("dataStoreMaxConns") int maxConnection,
            @JsonProperty("dataStoreConnUsageLimit") int connectionUsageLimit,
            @JsonProperty("dataStoreLogLevel") String logLevel,

            // etc
            @JsonProperty("staticPath") String staticPath,
            @JsonProperty("maxUrlLength") int maxUrlLength
    ){
        log.debug(" - RequireBaseInfo : {}, {}, {}, {}", name, email, poweredBy, poweredByIcon);
        log.debug(" - DefaultTemplate : {}, {}", defaultListTemplate, defaultFileTemplate);
        log.debug(" - CachePackageTags : {}, {}, {}", track, store, refresh);
        log.debug(" - DataStore : {}, {}, {}, {}, {}", useDataStore
                , logFile, initConnection, maxConnection, connectionUsageLimit, logLevel);

        return new SmallPieceObject(
                RequireBaseInfo.of(name, email, poweredBy, poweredByIcon)
                , DefaultTemplate.optional(defaultListTemplate, defaultFileTemplate)
                , CachePackageTags.optional(track, store, refresh)
                , DataStore.useDataStore(useDataStore)
                        .logFile(logFile)
                        .logLevel(logLevel)
                        .initConns(initConnection)
                        .maxConns(maxConnection)
                        .connUsageLimit(connectionUsageLimit)
                    .create()
                , etc()
                    .put("staticPath", staticPath)
                    .put("maxUrlLength", maxUrlLength)
        );
    }




}
