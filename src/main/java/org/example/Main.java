package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

public class Main {
    public static void main(String[] args) {
//        Dancer dancer = new Dancer("총알탄소년단", "춤신춤왕");           // Ctrl + Alt + v 단축키
//        dancer.dance();

//        IdolDancer idolDancer = new IdolDancer("AB6IX", "OOO");     // -> 부모 먼저 생성 후 자식 생성됨
//        StreetDancer streetDancer = new StreetDancer("길거리춤꾼들", "박격포");
//
//        idolDancer.dance();         // 상속받았기 때문에 dance() 사용 가능
//
//        System.out.println();
//
//        streetDancer.dance();

        // Dancer, Object 로 지정해도 문제가 없다는게 다형성의 기본 : 객체는 모양을 여러개로 지정할 수 있음
        Dancer idolDancer1 = new IdolDancer("아이돌팀1", "아이돌1");
        Dancer idolDancer2 = new IdolDancer("아이돌팀2", "아이돌2");
        Dancer idolDancer3 = new IdolDancer("아이돌팀3", "아이돌3");

        Dancer streetDancer1 = new StreetDancer("스트릿팀1", "스트릿댄서1");
        Dancer streetDancer2 = new StreetDancer("스트릿팀2", "스트릿댄서2");
        Dancer streetDancer3 = new StreetDancer("스트릿팀3", "스트릿댄서3");

        PerformanceTeam team = new PerformanceTeam();

        team.joinDancer(idolDancer1);
        team.joinDancer(streetDancer3);
    }
}