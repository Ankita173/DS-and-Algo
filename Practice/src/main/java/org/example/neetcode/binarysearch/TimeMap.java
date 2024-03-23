package org.example.neetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    class Pair {
        String key;
        String value;
        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    List<Integer> time;
    Map<Integer, Pair> timeMap;

    public TimeMap() {
        time = new ArrayList<>();
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.time.add(timestamp);
        Pair pair = new Pair(key, value);
        this.timeMap.put(this.time.size() - 1, pair);
    }

    public String get(String key, int timestamp) {
        int l = 0, r = this.time.size() - 1;
        int index = -1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (this.time.get(mid) == timestamp) {
                index = mid;
                break;
            } else if (this.time.get(mid) > timestamp) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if(index == -1) index = r;
        while(index >= 0) {
            Pair val = this.timeMap.get(index);
            if (val != null && val.key == key) return val.value;
            index--;
        }
        return "";
    }



//Another way
//    List<Integer> time;
//    Map<Integer, Map<String, String>> timeMap;
//
//    public TimeMap() {
//        time = new ArrayList<>();
//        timeMap = new HashMap<>();
//    }
//
//    public void set(String key, String value, int timestamp) {
//        this.time.add(timestamp);
//        Map<String, String> pair = new HashMap<>();
//        pair.put(key, value);
//        this.timeMap.put(this.time.size() - 1, pair);
//    }
//
//    public String get(String key, int timestamp) {
//        int l = 0, r = this.time.size() - 1;
//        int index = -1;
//        while (l <= r) {
//            int mid = (l+r) / 2;
//            if (this.time.get(mid) == timestamp) {
//                index = mid;
//                break;
//            } else if (this.time.get(mid) > timestamp) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        if(index == -1) index = r;
//        while(index >= 0) {
//            Map<String, String> val = this.timeMap.get(index);
//            if (val.containsKey(key)) return val.get(key);
//            index--;
//        }
//        return "";
//    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        System.out.println(obj.get("foo",1));
        System.out.println(obj.get("foo",3));
        obj.set("foo","bar2",4);


    }
}
