package org.example.tesco.RuleEngine;

public class Rule {

    int id;
    String ruleName;
    int quantityLimit;
    String category;
    int operation; //0 equal, 1 greaterthan -1 lessthan

    public Rule (int id, String ruleName, int quantityLimit, String category, int operation) {
        this.id = id;
        this.ruleName = ruleName;
        this.quantityLimit = quantityLimit;
        this.category = category;
        this.operation = operation;
    }

    public String getCategory() {
        return this.category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getQuantityLimit() {
        return quantityLimit;
    }

    public void setQuantityLimit(int quantityLimit) {
        this.quantityLimit = quantityLimit;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}

