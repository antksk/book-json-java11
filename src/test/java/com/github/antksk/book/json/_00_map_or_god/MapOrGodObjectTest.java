package com.github.antksk.book.json._00_map_or_god;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Slf4j
@JsonTest
class MapOrGodObjectTest {

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("[MAP] JSON 데이터를 읽을 떄, Map 자료형을 사용하게 되면 불편한 점")
    @ParameterizedTest
    @ValueSource(strings = {"MapOrGodObjectTest-1.json", "MapOrGodObjectTest-2.json", "MapOrGodObjectTest-3.json"})
    void map(String jsonFileName) throws IOException {
        final File file = ResourceUtils.getFile("classpath:_00_map_or_god/" + jsonFileName);
        final var map = objectMapper.readValue(file, Map.class);
        mapToLogic(map);
    }

    private void mapToLogic(Map<String, Object> map) {
        Object cachePackageTagsRefresh = map.getOrDefault("cachePackageTagsRefresh", 0);
        log.debug(
                "\n[cachePackageTagsRefresh type check]" +
                "\n - cachePackageTagsRefresh instanceof Long => result : {}" +
                "\n - cachePackageTagsRefresh instanceof Integer => result : {}"
                , cachePackageTagsRefresh instanceof Long
                , cachePackageTagsRefresh instanceof Integer
        );
        if(cachePackageTagsRefresh instanceof Integer){
            int i = (Integer) cachePackageTagsRefresh;
            if( 30 < i ){
                log.info("테스트 결과 출력 : {}", i);
            }
        }
    }


    @DisplayName("[GOD] JSON 데이터를 읽을 떄, GodObject 자료형을 사용하게 되면 불편한 점")
    @Disabled("MapOrGodObjectTest-3.json 읽을때, cachePackageTagsRefresh 값이 int형을 넘기 때문에 에러가 발생함")
    @ParameterizedTest
    @ValueSource(strings = {"MapOrGodObjectTest-1.json", "MapOrGodObjectTest-2.json", "MapOrGodObjectTest-3.json"})
    void godObject(String jsonFileName) throws IOException {
        final File file = ResourceUtils.getFile("classpath:_00_map_or_god/" + jsonFileName);
        final GodObject godObject = objectMapper.readValue(file, GodObject.class);
        godObjectToLogic(godObject);
    }

    private void godObjectToLogic(GodObject godObject) {
        int i = godObject.getCachePackageTagsRefresh();
        log.debug(
                "\n[cachePackageTagsRefresh type check]" +
                        "\n - result : {}"
                , i
        );
        if(30 < i){
            log.info("테스트 결과 출력 : {}", i);
        }
    }
}
