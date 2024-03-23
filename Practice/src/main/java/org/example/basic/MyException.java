package org.example.basic;

// extends RuntimeException -> UncheckException : Doesn't need to be caught
// extends Exception -> CheckedException/CompileTimeException : Needs to be handles (either catch or throws to caller)
public class MyException extends RuntimeException {
    MyException(String msg) {
        super(msg);
        System.out.println("Exception is "+msg);
    }

}
