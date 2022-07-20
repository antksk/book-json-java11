package com.github.antksk.book.json._00_map_or_god;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class GodObject {
    private String name;			        //   Philadelphia, PA,
    private String email;			        //   ksm@pobox.com,
    private String poweredBy;			    //   Cofax,
    private String poweredByIcon;			//   [null]
    private String staticPath;			    //   [null]
    private String defaultListTemplate;		//   [null]
    private String defaultFileTemplate;		//   [null]
    private int cachePackageTagsTrack;		//   0,
    private int cachePackageTagsStore;		//   0,
    private int cachePackageTagsRefresh;	//   0,
    private boolean useDataStore;			//   false,
    private String dataStoreLogFile;		//   [null],
    private int dataStoreInitConns;			//   0,
    private int dataStoreMaxConns;			//   0,
    private int dataStoreConnUsageLimit;	//   0,
    private String dataStoreLogLevel;		//   debug,
    private int maxUrlLength;			    //   0


    boolean isCachePackageTagsTrack(){
        return 0 <= cachePackageTagsTrack && 100 >= cachePackageTagsTrack;
    }

    boolean isCachePackageTagsStore(){
        return 0 <= cachePackageTagsStore && 1_000 >= cachePackageTagsStore;
    }

    boolean isCachePackageTagsRefresh(){
        return -1 <= cachePackageTagsRefresh && 100 >= cachePackageTagsRefresh;
    }
}
