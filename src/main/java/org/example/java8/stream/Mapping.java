//2023-01-12
package org.example.java8.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        List<String> dishNames = Dish.menu.stream()
                .map(dish -> dish.getName())        // T : dish 타입, R : String 타입 -> return : String 타입 (String<String>)
                .collect(Collectors.toList());
        System.out.println(dishNames.size());
        System.out.println("dishNames = " + dishNames);

        System.out.println("===========================================");
        System.out.println();

        List<String> words = List.of(
                "safari", "chrome", "ms edge", "opera", "firefox"
        );
        List<Integer> wordLengths = words.stream()
                .map(str -> str.length())   // T : String 타입, R : Integer 타입
                .collect(Collectors.toList());
        System.out.println("wordLengths = " + wordLengths);

        System.out.println("===========================================");
        System.out.println();
        
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        // nums 의 값들을 각각 제곱해서 새로운 리스트를 얻어내고 싶다.
        List<Integer> squares = nums.stream()       // stream 사용 시 사본을 만들어내는 것이기 때문에 원본을 지킬 수 있음
                .map(n -> n * n)        // T : Integer 타입, R : Integer 타입  --> Map 에서는 T와 R 타입이 동일할 수 있음
                .collect(Collectors.toList());
        System.out.println("squares = " + squares);

        System.out.println("===========================================");
        System.out.println();
        
        // 요리 목록의 총 칼로리 수 구하기
        int totalCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)        // map : 범용성 있음. 추출하는게 Int 형식이면 mapToInt 사용 --> 추가 메서드 존재(sum)
                .sum();
        System.out.println("totalCalories = " + totalCalories);

        System.out.println();
        
        // 육류 요리의 평균 칼로리
        OptionalDouble meatAverageCalories = Dish.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .mapToInt(Dish::getCalories)
                .average();
        System.out.println("meatAverageCalories = " + meatAverageCalories);

        // 만약 DB 에서 특정 게시물의 정보를 조회했는데 개시물이 없으면 null
        // Article article = repository.findByArticle(330) --> null 이라면
        // article.getTitle();      -> null 체크를 안하면 NullPointerException 발생
        // if (article != null) article.getTitle();

        // Optional 은 자동 널체크 지원 : ifPresent
        meatAverageCalories
                .ifPresent(cal -> System.out.println("cal: " + cal));

        // 육류 요리의 평균 칼로리
//        double meatAverageCalories = Dish.menu.stream()
//                .filter(dish -> dish.getType() == Dish.Type.MEAT)
//                .mapToInt(Dish::getCalories)
//                .average()
//                .getAsDouble();     // ifPresent 가 싫으면 처음부터 double 로 받으면 됨
//        System.out.println("meatAverageCalories = " + meatAverageCalories);
    }
}
