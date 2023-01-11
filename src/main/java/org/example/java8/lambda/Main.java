//2023-01-11
package org.example.java8.lambda;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 사과바구니 생성
        List<Apple> appleList = List.of(
                new Apple(80, Color.RED)
                , new Apple(155, Color.RED)
                , new Apple(120, Color.GREEN)
                , new Apple(97, Color.YELLOW)
                , new Apple(200, Color.GREEN)
                , new Apple(50, Color.YELLOW)
                , new Apple(85, Color.YELLOW)
                , new Apple(75, Color.RED)
        );

        List<Apple> greenApples = FilteringApple.filterGreenApples(appleList);
        System.out.println("=== 녹색 사과 필터링 ===");
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        System.out.println();

        List<Apple> wantedColorApples = FilteringApple.filterApplesByColor(appleList, Color.RED);
        System.out.println("=== 원하는 색상의 사과 필터링 ===");
        for (Apple wantedColorApple : wantedColorApples) {
            System.out.println(wantedColorApple);
        }
    }
}
