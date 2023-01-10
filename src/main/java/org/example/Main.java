package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;

public class Main {
    public static void main(String[] args) {
//        Dancer dancer = new Dancer("총알탄소년단", "춤신춤왕");           // Ctrl + Alt + v 단축키
//        dancer.dance();

        IdolDancer idolDancer = new IdolDancer("AB6IX", "OOO");     // -> 부모 먼저 생성 후 자식 생성됨
        StreetDancer streetDancer = new StreetDancer("길거리춤꾼들", "박격포");

        idolDancer.dance();         // 상속받았기 때문에 dance() 사용 가능

        System.out.println();

        streetDancer.dance();
    }
}