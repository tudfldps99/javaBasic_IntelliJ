//2023-01-11
package org.example.java8.stream;

import java.util.List;

import static java.util.stream.Collectors.*;

public class Filtering {

    public static void main(String[] args) {

        // stream 의 filter : return 조건에 맞는 데이터만 필터링

        /*
         요구사항)
          요리 목록 중에 채식주의자가 먹을 수 있는 음식만 필터링 해주세요.
        */
        List<Dish> vegetarianDishes = Dish.menu.stream()
                .filter(Dish::isVegetarian)        // 필터링
                .collect(toList());                // 수집

//        for (Dish vegetarianDish : vegetarianDishes){
//            System.out.println(vegetarianDish);
//        }

        // 위의 for 문 stream 형태로 변경 가능
//        vegetarianDishes.stream()
//                .forEach(dish -> System.out.println(dish));

        vegetarianDishes.forEach(System.out::println); // .stream() 생략 가능

        System.out.println("=====================================================================");
        System.out.println();

        /*
         요구사항)
          요리 목록 중에 육류이면서 600칼로리 미만인 음식만 필터링 해주세요.
        */
        Dish.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT && dish.getCalories() < 600)
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("=====================================================================");
        System.out.println();

        // 필터링 된 요소 중복 제거
        List<Integer> nums = List.of(1, 2, 1, 3, 3, 2, 4, 4, 5, 6);
        /*
         요구사항)
           nums 리스트에서 짝수만 필터링 한 후 중복을 제거
        */
        nums.stream()
                .filter(n -> n % 2 == 0)        // 짝수만 필터링
                .distinct()         // 중복 제거
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("=====================================================================");
        System.out.println();

        // 원하는 개수만  필터링하기
        /*
         요구사항)
           300칼로리보다 큰 요리 중, 처음 발견된 3개말 필터링
        */
        Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)           // 앞에서부터 3개만
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("=====================================================================");
        System.out.println();

        // 요소 생략해서 필터링하기
        /*
         요구사항)
           300칼로리보다 큰 요리 중, 처음 2개는 제외하고 필터링
        */
        Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)            // 앞에 2개 제외
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("=====================================================================");
        System.out.println();

        /*
         요구사항)
           스트림을 사용하여 처음 등장하는 고기 요리 2개 필터링
        */
        Dish.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList())
                .forEach(System.out::println);
    }
}
