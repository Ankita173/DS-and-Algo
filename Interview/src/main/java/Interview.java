

//Tesco gets millions of orders every day with an average basket size of 100 items. Tesco Business has got some regulations around selling products online and in stores.
// These regulations are mandatory from legal and business perspective to enforce for all order transactions.
//
//You are given an order with a list of products in the shopping cart/basket with productid, product Category and quantity. And also, Restriction Rules on Qty and Qty/Category.
//
//        Example:
//
//Ordered items in the shopping cart/basket
//
//Item-1 -> productid=1, category=Paracetamol, quantity=3
//
//Item-2 -> productid=2, category=analgesic, quantity=3
//
//Item-3 -> productid=3, category=chocolate, quantity=8
//
//Item-4 -> productid=4, category= Paracetamol, quantity=2
//
//Business Restriction rules:
//
//Cannot buy more than 10 Quantity of any products - BulkBuyLimit
//
//Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory
//
//Write a restriction rule engine to run the restriction check against the shopping cart/basket and return the status as to MET/BREACHED indicating restriction status for the given restriction rules.
//
//For the above given example, the restriction status returned would be MET.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Interview {
    public static void main(String[] args) {
        RuleService ruleEngine = new RuleService();
//        System.out.printf("Hello");

        //case 1: with casing and combined breached
        List<CartDto> cart = new ArrayList<>();
        cart.add(new CartDto(1, "Paracetamol", 3));
        cart.add(new CartDto(2, "analgesic", 3));
        cart.add(new CartDto(3, "chocolate", 8));
        cart.add(new CartDto(3, "paracetamol", 3));

        if(ruleEngine.checkout(cart).equals("BREACHED")) System.out.printf("TRUE");
        else System.out.printf("FALSE");

        //case 2: bulk buy limit breached
        List<CartDto> cart1 = new ArrayList<>();
        cart1.add(new CartDto(1, "Paracetamol", 3));
        cart1.add(new CartDto(2, "analgesic", 10));
        cart1.add(new CartDto(3, "chocolate", 8));
        cart1.add(new CartDto(3, "paracetamol", 2));

        if(ruleEngine.checkout(cart1).equals("BREACHED")) System.out.printf("TRUE");
        else System.out.printf("FALSE");

        //case 3: limit category breached
        List<CartDto> cart2 = new ArrayList<>();
        cart2.add(new CartDto(1, "Paracetamol", 5));
        cart2.add(new CartDto(2, "analgesic", 3));
        cart2.add(new CartDto(3, "chocolate", 8));

        if(ruleEngine.checkout(cart2).equals("BREACHED")) System.out.printf("TRUE");
        else System.out.printf("FALSE");

        //case 1: MET situation
        List<CartDto> cart3 = new ArrayList<>();
        cart3.add(new CartDto(1, "Paracetamol", 3));
        cart3.add(new CartDto(2, "analgesic", 3));
        cart3.add(new CartDto(3, "chocolate", 8));
        cart3.add(new CartDto(3, "paracetamol", 2));
        if(ruleEngine.checkout(cart2).equals("MET")) System.out.printf("TRUE");
        else System.out.printf("FALSE");

        //case 1: MET situation
        List<CartDto> cart4 = new ArrayList<>();
        cart4.add(new CartDto(2, "analgesic", 3));
        cart4.add(new CartDto(3, "chocolate", 8));

        if(ruleEngine.checkout(cart4).equals("MET")) System.out.printf("TRUE");
        else System.out.printf("FALSE");

    }

}

class RuleService {
    List<String> rules = new ArrayList<>();
    Map<String, Integer> limitCategory = new HashMap<>();
    int bulkBuyLimit;

    public RuleService() {
        rules.add("BulkBuyLimit");
        rules.add("BulkBuyLimitCategory");
        limitCategory.put("paracetamol", 5);
        bulkBuyLimit = 10;
    }

    public String checkout(List<CartDto> cart) {
        Map<String, Integer> cartDetails = new HashMap<>();
        for (CartDto item : cart) {
            String lowerCaseCategory = item.category.toLowerCase();
            cartDetails.put(lowerCaseCategory, cartDetails.getOrDefault(lowerCaseCategory, 0) + item.quantity);
        }

        if (applyRule(cartDetails))
            return "MET";
        else return "BREACHED";
    }

    private boolean applyRule(Map<String, Integer> cart) {
        for (String category: cart.keySet()) {
            for (String rule : rules) {
                switch (rule) {
                    case "BulkBuyLimit":
                        if (cart.get(category) > bulkBuyLimit) {
                            return false;
                        }
                        break;
                    case "BulkBuyLimitCategory":
                        if(limitCategory.containsKey(category) && cart.get(category) > limitCategory.get(category)) {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }
}

interface Rule {
    public boolean applyRule(CartDto cart);
}

class BulkBuyLimit implements Rule {
    int limit;

    public BulkBuyLimit (int limit) {
        this.limit = limit;
    }

    @Override
    public boolean applyRule(CartDto cart) {
        if (cart.quantity > limit) {
            return false;
        }
        return true;
    }
}

class BulkBuyLimitCategory implements Rule {
    int limit;

    public BulkBuyLimitCategory (int limit) {
        this.limit = limit;
    }

    @Override
    public boolean applyRule(CartDto cart) {
        if (cart.quantity > limit) {
            return false;
        }
        return true;
    }
}


/*TOdo:

1. adding of logs
2. Use of constants and enuminstead of raw strings
3. Run time performance details
4. upper cap for cart item checks
 */





class CartDto {
    int productId;
    String category;
    int quantity;
    public CartDto(int id, String category, int quantity) {
        this.productId = id;
        this.category = category;
        this.quantity =  quantity;
    }
}
