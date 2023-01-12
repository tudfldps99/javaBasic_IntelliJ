//2023-01-12
package org.example.java8.stream;

public class Finding {
    public static void main(String[] args) {

        // anyMatch, allMatch, noneMatch 모두 filter, map 과 함께 사용 가능

        /* anyMatch : 주어진 스트림에서 적어도 한 요소와 일치하는게 있는지 [확인] (true / false) */
        // 요리 목록 중에 채식주의자가 먹을 수 있는 요리가 하나라도 있는가?
        boolean flag1 = Dish.menu.stream()
                .anyMatch(Dish::isVegetarian);

        System.out.println("flag1 = " + flag1);

        System.out.println();

        // 요리 목록 중에 100 칼로리보다 작은 요리가 하나라도 있는가
        boolean flag2 = Dish.menu.stream()
                .anyMatch(dish -> dish.getCalories() < 100);
        System.out.println("flag2 = " + flag2);

        System.out.println();

        /* allMatch : 모든 요소가 조건에 일치하는지 확인 */
        // 요리 목록의 모든 요리가 1000 칼로리 미만인가?
        boolean flag3 = Dish.menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("flag3 = " + flag3);

        /* nonMatch : allMatch 의 반대연산 */
    }
}
