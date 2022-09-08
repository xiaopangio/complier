package com.xiaobai.complier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * className: LexicalAnalyzer
 * description:词法分析器
 * author: xiaopangio
 * date: 2022/9/8 19:43
 * version: 1.0
 */
public class LexicalAnalyzer {


    private String input;
    private int index;
    private ArrayList<String> keyWordTokens;
    private ArrayList<String> separatorTokens;
    private ArrayList<String> operatorTokens;
    private ArrayList<String> identifierTokens;
    private ArrayList<String> constantTokens;
    private int[] next;

    public LexicalAnalyzer(String input) {
        this.input = input;
        this.index = 0;
        this.keyWordTokens = new ArrayList<>();
        this.separatorTokens = new ArrayList<>();
        this.operatorTokens = new ArrayList<>();
        this.identifierTokens = new ArrayList<>();
        this.constantTokens = new ArrayList<>();
        next = this.getNext(input);
    }

    public void analyze() {
        findKeyWordTokens();
        findSeparatorTokens();
        findOperatorTokens();
        findIdentifierTokens();
        findConstantTokens();
    }

    public void findKeyWordTokens() {
        for (KeyWords keyWord : KeyWords.values()) {
            String value = keyWord.getValue();
            int i = indexOf(input, value);
            if (i != -1) {
                keyWordTokens.add(value);
            }
        }
    }

    public void findSeparatorTokens() {
        for (Separator separator : Separator.values()) {
            String value = separator.getValue();
            int i = indexOf(input, value);
            if (i != -1) {
                separatorTokens.add(value);
            }
        }
    }

    public void findOperatorTokens() {
        for (Operators operator : Operators.values()) {
            String value = operator.getValue();
            int i = indexOf(input, value);
            if (i != -1) {
                if (value.equals("=")) {
                    if (input.charAt(i + 1) == '=') {
                        continue;
                    }
                }
                operatorTokens.add(value);
            }
        }
    }

    private void findIdentifierTokens() {
        char[] chars = input.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int last = findIdentifier(chars, i);
            if (last == i) {
                i++;
            } else {
                identifierTokens.add(input.substring(i, last));
                i = last + 1;
            }
        }
        for (KeyWords keyWord : KeyWords.values()) {
            String value = keyWord.getValue();
            identifierTokens.remove(value);
        }
        identifierTokens = (ArrayList<String>) duplicate(identifierTokens);
    }

    private List<String> duplicate(ArrayList<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    private int findIdentifier(char[] chars, int i) {
        while (i < chars.length && Character.isLetter(chars[i])) {
            i++;
        }
        return i;
    }

    private boolean check(char achar) {
        return isLetter(achar) || isDigit(achar) || achar == '_';
    }

    private boolean isLetter(char aChar) {
        return (aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z');
    }

    private boolean isDigit(char aChar) {
        return aChar >= '0' && aChar <= '9';
    }

    private void findConstantTokens() {
        int i = 0;
        char[] chars = input.toCharArray();
        while (i < chars.length) {
            int last = getNumber(chars, i);
        }
    }

    private int getNumber(char[] chars, int i) {
        int pointCount = 0;
        int subCount = 0;
        while (i < chars.length) {
            if (isDigit(chars[i])) {
                i++;
            }
            if(chars[i]=='.'){
                if(pointCount!=0){
                    return -1;
                }
                pointCount++;
                i++;
            }
        }
        return i;
    }

    public int indexOf(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        char[] patternArr = pattern.toCharArray();
        char[] strArr = str.toCharArray();
        int i1 = 0;
        int i2 = 0;
        while (i1 < n && i2 < m) {
            if (strArr[i1] == patternArr[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == m ? i1 - i2 : -1;
    }

    public int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i - 1) == pattern.charAt(cn)) {
                next[i++] = ++cn;
            } else {
                if (cn > 0) {
                    cn = next[cn];
                } else {
                    next[i++] = 0;
                }
            }
        }
        return next;
    }

    public void setInput(String input) {
        this.keyWordTokens.clear();
        this.separatorTokens.clear();
        this.operatorTokens.clear();
        this.identifierTokens.clear();
        this.constantTokens.clear();
        this.next = getNext(input);
        this.input = input;
    }

    public ArrayList<String> getKeyWordTokens() {
        return keyWordTokens;
    }

    public ArrayList<String> getSeparatorTokens() {
        return separatorTokens;
    }

    public ArrayList<String> getOperatorTokens() {
        return operatorTokens;
    }

    public ArrayList<String> getIdentifierTokens() {
        return identifierTokens;
    }

    public ArrayList<String> getConstantTokens() {
        return constantTokens;
    }

    public void print() {
        System.out.println("关键字：");
        for (String keyWordToken : keyWordTokens) {
            System.out.println(keyWordToken);
        }
        System.out.println("分隔符：");
        for (String separatorToken : separatorTokens) {
            System.out.println(separatorToken);
        }
        System.out.println("运算符：");
        for (String operatorToken : operatorTokens) {
            System.out.println(operatorToken);
        }
        System.out.println("标识符：");
        for (String identifierToken : identifierTokens) {
            System.out.println(identifierToken);
        }
        System.out.println("常量：");
        for (String constantToken : constantTokens) {
            System.out.println(constantToken);
        }
    }
}
