//2023-01-11
package org.example.java8.lambda;

import lombok.*;

import java.util.List;

public class Main {

    //  무게가 100그램 이하인 사과 필터 조건 클래스
    public static class LightApplePredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() <= 100;
        }
    }

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

        System.out.println();

        System.out.println("=== 원하는 조건으로 사과 필터링 ===");
        // 노란색 사과만 필터링
        List<Apple> yellowApples = FilteringApple.filterApples(appleList, new YellowApplePredicate());
        for (Apple yellowApple : yellowApples) {
            System.out.println(yellowApple);
        }
        System.out.println("===================================");
        // 무게가 100그램 이하인 사과만 필터링 --> [내부클래스] 이용
        List<Apple> lightApples = FilteringApple.filterApples(appleList, new LightApplePredicate());
        for (Apple lightApple : lightApples) {
            System.out.println(lightApple);
        }
        System.out.println("===================================");
        // 무게가 100그램 이상인 사과만 필터링 --> [익명클래스] 이용
        List<Apple> heavyApples = FilteringApple.filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 100;
            }
        });
        for (Apple heavyApple : heavyApples) {
            System.out.println(heavyApple);
        }
        System.out.println("===================================");

        //  녹색 사과만 필터링 --> [람다] 이용
        // 람다 사용 전제 조건 : 인터페이스(ApplePredicate.java)의 추상메서드가 단 하나일 것 (static, default 메서드는 괜찮음)
        // 람다가 오버라이딩하는 메서드가 단 한 줄일 경우 중괄호 생략 가능
        // 그 한줄이 return 문이라면 return 키워드 생략 가능
        // 파라미터가 단 한개라면 소괄호 생략 가능 (파라미터 이름은 내 마음대로 지정 가능)
        List<Apple> greenAppleLists = FilteringApple.filterApples(appleList, apple -> apple.getColor() == Color.GREEN);
        for (Apple greenAppleList : greenAppleLists) {
            System.out.println(greenAppleList);
        }

        System.out.println("===================================");
        // 빨간색 사과면서 100그램 이상인 사과만 필터링
        List<Apple> ColorWeightAppleLists =  FilteringApple.filterApples(appleList, apple -> apple.getColor() == Color.RED && apple.getWeight() >= 100);
        for (Apple ColorWeightAppleList : ColorWeightAppleLists) {
            System.out.println(ColorWeightAppleList);
        }

        System.out.println();

        System.out.println("=== 제너릭 필터 메서드 ===");
        List<Apple> GenericAppleLists =   FilteringApple.filterGeneric(appleList, a -> a.getColor() == Color.RED);     // 빨간사과만 필터링
        // 20번째 줄에서 List<Apple> 로 작성해줬기 때문에 GenericPredicate 의 <T>에는 <Apple>이 들어감
        for (Apple GenericAppleList : GenericAppleLists) {
            System.out.println(GenericAppleList);
        }

        System.out.println("===================================");

        List<Integer> numbers = List.of(
                1,2,3,4,5,6,7,8,9,10
        );
        List<Integer> evenNumbers = FilteringApple.filterGeneric(numbers, n-> n % 2 == 0);     // 짝수만 필터링
        System.out.println("=== 짝수만 필터링 ===");
        System.out.println(evenNumbers);

        System.out.println();

        System.out.println("=== 변경 메서드 ===");
        // 사과 리스트에서 사과의 색상만 추출하여 새로운 색상리스트를 반환
        // <T> : Apple, <R> : Color
//        List<Color> colorList =  FilteringApple.map(appleList, apple -> apple.getColor());     // 색상만 모두 추출
//        System.out.println("colorList = " + colorList);

        List<Color> colorList =  FilteringApple.map(appleList, Apple::getColor);     // 색상만 모두 추출           apple -> apple.getColor() : Apple.getColor
        System.out.println("colorList = " + colorList);

        List<Integer> weightList =  FilteringApple.map(appleList, Apple::getWeight);     // 무게만 모두 추출
        System.out.println("weightList = " + weightList);

//        List<AppleInfo> appleInfos = FilteringApple.map(appleList, a -> new AppleInfo(a.getColor(), a.getWeight()));    // 색상, 무게 모두 추출
//        System.out.println("appleInfos = " + appleInfos);
        List<AppleInfo> appleInfos = FilteringApple.map(appleList, AppleInfo::new);    // 색상, 무게 모두 추출
        System.out.println("appleInfos = " + appleInfos);

        // 전체 사과 색 변경
        // <T> : Apple, <R> : Apple
        List<Apple> yellows = FilteringApple.map(appleList, a -> {
            a.setColor(Color.YELLOW);
            return a;
        });
        for (Apple yellow : yellows) {
            System.out.println(yellow);
        }
    }
    
    // 사과에서 필요한 데이터 몇개만 추출
    @Getter @NoArgsConstructor @ToString @AllArgsConstructor
    public static class AppleInfo {
        private Color color;
        private int weight;

        public AppleInfo(Apple a) {
            this.color = a.getColor();
            this.weight = a.getWeight();
        }

        /*
            //@AllArgsConstructor 대신 사용
            public AppleInfo(Color color, int weight) {
                this.color = color;
                this.weight = weight;
            }
         */
    }
}
