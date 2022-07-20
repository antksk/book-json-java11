package com.github.antksk.book.json.mock;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import java.util.function.Function;

@RequiredArgsConstructor
abstract class AbstractMockJsonFileController {
    private final ObjectMapper objectMapper;

    protected ResponseEntity<JsonNode> jsonFile(String resourceLocation, Function<JsonNode, JsonNode> convert){
        try{
            JsonNode jsonNode = objectMapper.readTree(ResourceUtils.getFile(resourceLocation));
            return ResponseEntity.ok(convert.apply(jsonNode));
        }catch (Exception e){
            return ResponseEntity
                    .notFound().build();
        }
    }

    protected ResponseEntity<JsonNode> jsonFile(String resourceLocation){
        return jsonFile(resourceLocation, Function.identity());
    }
}
