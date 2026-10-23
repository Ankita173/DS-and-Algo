package org.example.tesco.RuleEngine.cart;

import org.example.tesco.RuleEngine.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    int id;
    List<ProductItem> items;

    List<Rule> rules;

    public Cart(int id) {
        this.id = id;
        items = new ArrayList<>();
        initRules();
    }

    public void addItems(ProductItem item) {
        this.items.add(item);
    }

    public boolean validate() {
        int total = 0;
       // int totalAllowed = 0;
        Map<String, Integer> categoryCount = new HashMap<>();
        for (ProductItem item : items) {
            total += item.quantity;
            categoryCount.put(item.category, categoryCount.getOrDefault(item.category, 0) + item.quantity);
            for (Rule rule : rules) {
//                if (null == rule.getCategory()) {
//                    totalAllowed = rule.getQuantityLimit();
//                    continue;
//                }
                if (null != rule.getCategory() && item.category.equals(rule.getCategory())) {
                    if (rule.getOperation() > 0)
                         return categoryCount.get(item.category) > rule.getQuantityLimit();
                    else if (rule.getOperation() < 0)
                        return categoryCount.get(item.category) < rule.getQuantityLimit();
                    else
                        return categoryCount.get(item.category) != rule.getQuantityLimit();
                }
            }
            return true;
        }
        return false;
    }


    public List<Rule> initRules() {
        List<Rule> ruleList = new ArrayList<>();
        ruleList.add(new Rule(1, "BulkBuyLimit", 10, null, 1));
        ruleList.add(new Rule(2, "BulkBuyLimitCategory", 5, "Paracetamol", 1));
        return ruleList;
    }
}
