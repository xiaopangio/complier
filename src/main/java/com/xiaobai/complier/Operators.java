package com.xiaobai.complier;

public enum Operators {
    //运算符
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MOD("%"),
    ASSIGN("="),
    EQUAL("=="),
    NOT_EQUAL("!="),
    GREATER(">"),
    LESS("<"),
    GREATER_EQUAL(">="),
    LESS_EQUAL("<="),
    AND("&&"),
    OR("||"),
    NOT("!");

    private final String value;

    Operators(String s) {
        this.value=s;
    }

    public String getValue() {
        return value;
    }
}
