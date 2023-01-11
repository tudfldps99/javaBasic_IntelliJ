//2023-01-11
package org.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilteringApple {

    /*
     * @solution - try1 : 녹색사과를 필터링 하는 메서드를 만들어야 함.
     * @problem - 만약 다른 색의 사과를 필터링 해야 하는 경우에는?
     *          - 새로운 메서드를 또 만들어야 한다.
    */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {

        List<Apple> result = new ArrayList<>();     // 녹색 사과들만 담을 바구니 생성
        for (Apple apple : inventory) {        // iter 단축키
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * @solution - try2 : 색상을 파라미터화 한다.
     * @problem - 만약 필터 기준이 색상이 아니라 무게였다면?
     *          - 두번째 파라미터로 무게 기준을 받아내는 메서드를 또만들어?
     *          - 안만들고 한번에 하는 방법은?
    */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * @solution - try3 : 동작을 파라미터화 한다. (if 조건을 파라미터화) - 추상적 조건으로 필터링
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, Color color) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }
}
