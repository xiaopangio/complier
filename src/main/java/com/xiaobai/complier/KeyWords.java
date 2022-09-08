package com.xiaobai.complier;

/**
 * className: KeyWords
 * description:
 * author: xiaopangio
 * date: 2022/9/8 19:47
 * version: 1.0
 */
public enum KeyWords {
    //关键字
    IF("if"),
    ELSE("else"),
    WHILE("while"),
    FOR("for"),
    DO("do"),
    BREAK("break"),
    CONTINUE("continue"),
    RETURN("return"),
    INT("int"),
    FLOAT("float"),
    DOUBLE("double"),
    CHAR("char"),
    STRING("string"),
    BOOL("bool"),
    VOID("void"),
    TRUE("true"),
    FALSE("false"),
    NULL("null"),;
    private final String value;

    KeyWords(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
