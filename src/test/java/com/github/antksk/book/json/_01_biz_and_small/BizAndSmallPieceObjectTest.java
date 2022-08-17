package com.github.antksk.book.json._01_biz_and_small;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.antksk.book.json._01_biz_and_small.piece.SmallPieceObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.util.ResourceUtils;

import java.io.File;

@Slf4j
@JsonTest
class BizAndSmallPieceObjectTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test() throws Exception {
        String name = "", email ="", poweredBy = "";
//        RequireBaseInfo b = RequireBaseInfo.of(name, email, poweredBy);
        String jsonFileName = "jsonTestCase_3.json";
        final File file = ResourceUtils.getFile("classpath:" + jsonFileName);
        final var map = objectMapper
                .readValue(file, SmallPieceObject.class);
        log.debug("\n{}", map);
    }
}
