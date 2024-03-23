package org.example.basic;

import java.util.HashMap;
import java.util.Map;

public class MapTrickQuestions {
    private String a;
    private String b;

    public MapTrickQuestions(String a, String b) {
        this.a = a;
        this.b = b;
    }
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int hashCode(){
        return 13;
    }

    public static void main(String[] args) {
        MapTrickQuestions m1 = new MapTrickQuestions("a", "b");
        MapTrickQuestions m2 = new MapTrickQuestions("c", "d");
        Map<MapTrickQuestions, String> map = new HashMap();
        map.put(m1, "1");
        map.put(m2, "2");
        System.out.println(map.size());

    }

}
