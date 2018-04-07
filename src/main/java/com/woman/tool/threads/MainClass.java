package com.woman.tool.threads;
public class MainClass {

    public static void main(String[] args) {
        method1();
    }
    public static void method1() {
        sellMovie sell = new sellMovie();
        
        new Thread(sell, "美團").start();
        new Thread(sell, "糯米").start();
    }
}            