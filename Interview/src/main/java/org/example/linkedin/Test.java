package org.example.linkedin;

//Basic java
//finally will always get executed no matter what if exception is thrown or encountered return what-so-ever
//final modifier stops further enhancements/modification to variable/method/class
//execution get's stored in stack and definitions stored in heap
public class Test {

    public static void main(String[] args) {
        System.out.println(whatItWillReturn());
    }

    final static int whatItWillReturn() {
        String s = "null";
        try {
            s.length();
            return 1;
        } catch (NullPointerException e) {
            return 2;
        } finally {
            return 3;
        }
    }
}

final class Test2 extends Test {
//    static int whatItWillReturn() {
//        System.out.println("Sorry! can't be overriden as it's final..");
//    }
}

//class Test3 extends Test2 {
//    //Can't inherit as class2 is final
//}
