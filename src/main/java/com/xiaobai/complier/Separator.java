package com.xiaobai.complier;

public enum Separator {
//    分隔符
    LEFT_BRACKET("("),
    RIGHT_BRACKET(")"),
    LEFT_BRACE("{"),
    RIGHT_BRACE("}"),
    LEFT_BRACKET_SQUARE("["),
    RIGHT_BRACKET_SQUARE("]"),
    COMMA(","),
    SEMICOLON(";"),
    DOUBLE_QUOTATION_MARK("\""),
    SINGLE_QUOTATION_MARK("'"),
    BACKSLASH("\\"),
    BACKSLASH_N("\\n"),
    BACKSLASH_T("\\t"),
    BACKSLASH_R("\\r"),
    BACKSLASH_B("\\b"),
    BACKSLASH_F("\\f"),
    BACKSLASH_A("\\a"),
    BACKSLASH_V("\\v"),
    BACKSLASH_0("\\0"),
    BACKSLASH_1("\\1"),
    BACKSLASH_2("\\2"),
    BACKSLASH_3("\\3"),
    BACKSLASH_4("\\4"),
    BACKSLASH_5("\\5"),
    BACKSLASH_6("\\6"),
    BACKSLASH_7("\\7"),
    BACKSLASH_8("\\8"),
    BACKSLASH_9("\\9"),
    BACKSLASH_X("\\x"),
    BACKSLASH_U("\\u"),
    ;

    private final String value;

    Separator(String s) {
        this.value=s;
    }

    public String getValue() {
        return value;
    }
}
