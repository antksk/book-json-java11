package com.github.antksk.book.json._01_biz_and_small.piece;

import lombok.ToString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.github.antksk.book.json._01_biz_and_small.piece.EtcValue.intValue;
import static com.github.antksk.book.json._01_biz_and_small.piece.EtcValue.strValue;

@ToString
final class Etc implements Iterable<String>{
    private final Map<String, EtcValue> etc;

    Etc() {
        this.etc = new HashMap<>();
    }

    static Etc etc(){
        return new Etc();
    }

    Etc put(String key, int value){
        etc.put(key, intValue(value));
        return this;
    }

    Etc put(String key, String value){
        etc.put(key, strValue(value));
        return this;
    }

    int getOrDefault(String key, int defaultValue){
        return etc.getOrDefault(key, intValue(defaultValue))
                .getInt();
    }

    String getOrDefault(String key, String defaultValue){
        return etc.getOrDefault(key, strValue(defaultValue))
                .getString();
    }

    @Override
    public Iterator<String> iterator() {
        return etc.keySet().iterator();
    }
}
