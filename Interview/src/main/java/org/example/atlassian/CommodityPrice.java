package org.example.atlassian;

import java.util.*;

public class CommodityPrice {

    public static void main(String[] args) {

        RunningCommodityPrice r = new RunningCommodityPriceImpl();
        r.upsertCommodityPrice(4, 27);
        r.upsertCommodityPrice(6, 26);
        r.upsertCommodityPrice(9, 25);
        System.out.println(r.getMaxCommodityPrice()); // output should be 27 which is at timestamp 4
        r.upsertCommodityPrice(4, 28); // timestamps can come out of order and there can be 11 // the commodity price at timestamp 4 got updated
//to 28, so the max commodity price is 28
        System.out.println(r.getMaxCommodityPrice());

        r.upsertCommodityPrice(4, 25); // timestamps can come out of order and there can be 11 // the commodity price at timestamp 4 got updated
//to 28, so the max commodity price is 28
        System.out.println(r.getMaxCommodityPrice());

        r.upsertCommodityPrice(6, 21); // timestamps can come out of order and there can be 11 // the commodity price at timestamp 4 got updated
//to 28, so the max commodity price is 28
        System.out.println(r.getMaxCommodityPrice());

    }


}


interface RunningCommodityPrice {
 void upsertCommodityPrice(int timestamp, int commodityPrice);
 int getMaxCommodityPrice();
}

class RunningCommodityPriceImpl implements RunningCommodityPrice {

    Map<Integer, Integer> timeToPriceMap = new HashMap<>();
    Map<Integer, Set<Integer>> priceToTimeMap = new TreeMap<>();

    Integer maxCommodityPrice = null;

    @Override
    public void upsertCommodityPrice(int timestamp, int commodityPrice) {
//        Integer oldTimestampPrice = timeToPriceMap.getOrDefault(timestamp, null);
//        timeToPriceMap.put(timestamp, commodityPrice);
//
//        Set<Integer> timestamps = priceToTimeMap.getOrDefault(commodityPrice, new LinkedHashSet<>());
//        timestamps.add(timestamp);
//        priceToTimeMap.put(commodityPrice, timestamps);
//
//        if (Objects.nonNull(oldTimestampPrice)) {
//            if (priceToTimeMap.get(oldTimestampPrice).size() > 1) {
//                Set<Integer> timestampsForOldPrice = priceToTimeMap.get(oldTimestampPrice);
//                timestampsForOldPrice.remove(timestamp);
//                priceToTimeMap.put(oldTimestampPrice, timestampsForOldPrice);
//            } else priceToTimeMap.remove(oldTimestampPrice);
//        }





//        Integer oldCommodityPrice =
//                timeToPriceMap.put(timestamp, commodityPrice);
//        if (oldCommodityPrice != null) {
//            priceToTimeMap.get(oldCommodityPrice).remove(timestamp);
//            if (priceToTimeMap.get(oldCommodityPrice).isEmpty()) {
//                priceToTimeMap.remove(oldCommodityPrice);
//            }
//        }
//        priceToTimeMap.computeIfAbsent(commodityPrice, k
//                        -> new HashSet<>()).add(timestamp);

        for (Integer price : priceToTimeMap.keySet()) {
            maxCommodityPrice = price;
        }

    }

    @Override
    public int getMaxCommodityPrice() {
        return Objects.nonNull(maxCommodityPrice) ? maxCommodityPrice : -1;
    }
}

