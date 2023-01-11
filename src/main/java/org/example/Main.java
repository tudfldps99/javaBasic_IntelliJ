package org.example;

import org.example.basic.Dancer;
import org.example.beans.Goods;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Dancer dancer = new Dancer("총알탄소년단", "춤신춤왕");           // Ctrl + Alt + v 단축키
//        dancer.dance();

//        IdolDancer idolDancer = new IdolDancer("AB6IX", "OOO");     // -> 부모 먼저 생성 후 자식 생성됨
//        StreetDancer streetDancer = new StreetDancer("길거리춤꾼들", "박격포");
//
//        idolDancer.dance();         // 상속받았기 때문에 dance() 사용 가능
//        System.out.println();
//        streetDancer.dance();

        // new Dancer();       // Dancer 는 abstract

        // Dancer, Object 로 지정해도 문제가 없다는게 다형성의 기본 : 객체는 모양을 여러개로 지정할 수 있음
        /*
        IdolDancer idolDancer1 = new IdolDancer("아이돌팀1", "아이돌1");
        Dancer idolDancer2 = new IdolDancer("아이돌팀2", "아이돌2");
        Dancer idolDancer3 = new IdolDancer("아이돌팀3", "아이돌3");

        StreetDancer streetDancer1 = new StreetDancer("스트릿팀1", "스트릿댄서1");
        Dancer streetDancer2 = new StreetDancer("스트릿팀2", "스트릿댄서2");
        Dancer streetDancer3 = new StreetDancer("스트릿팀3", "스트릿댄서3");

        PerformanceTeam team = new PerformanceTeam();

        team.joinDancer(idolDancer1);
        team.joinDancer(streetDancer3);

        System.out.println();

        team.groupDance();

        idolDancer1.rap();
        idolDancer1.dance();
        idolDancer1.sing();

        streetDancer1.rap();
        streetDancer1.dance();
        //streetDancer1.sing();       // StreetDancer 에는 singer interface 가 제한 ==> 객체의 행위를 interface 가 제한 가능
        */

        Goods goods1 = new Goods("세탁기", 300000);
        Goods goods2 = new Goods("세탁기", 300000);

        System.out.println("goods1 = " + goods1.toString());   // soutv 단축키
        System.out.println("goods2 = " + goods2);
//        System.out.println(Integer.toHexString(goods1.hashCode()));

        System.out.println("(good1 == good2) : " + (goods1 == goods2));
        System.out.println("(goods1 equals goods2) : " + (goods1.equals(goods2)));      // 처음엔 false --> equals 에서는 true 가 나오도록 overriding 필요

        // Set 은 중복 허용 X --> (st1.size() = 2)
        Set<String> set1 = new HashSet<>();
        set1.add("짜장면");
        set1.add("짬뽕");
        set1.add("짜장면");

        System.out.println("set1 = " + set1);
        System.out.println("set1.size() = " + set1.size());

        // set2 에는 2개의 값이 동일함에도 2개 모두 들어감 why? Hash값이 다르기 때문 --> hashCode overriding 필요
        Set<Goods> set2 = new HashSet<>();
        set2.add(goods1);
        set2.add(goods2);

        System.out.println("set2 = " + set2);
        System.out.println("set2.size() = " + set2.size());
    }
}