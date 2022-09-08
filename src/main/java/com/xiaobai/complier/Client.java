package com.xiaobai.complier;

/**
 * className: Client
 * description:
 * author: xiaopangio
 * date: 2022/9/8 20:23
 * version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        String input ="if(a==b){return a+b;}";
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(input);
        lexicalAnalyzer.analyze();
        lexicalAnalyzer.print();
        input="while(a==b){return a+b;}";
        lexicalAnalyzer.setInput(input);
        lexicalAnalyzer.analyze();
        lexicalAnalyzer.print();
    }
}
