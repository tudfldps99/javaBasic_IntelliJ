//2023-01-11
package org.example.java8.stream.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값)
        // List<Transaction>
        List<Transaction> tr2021 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2021)
                // .sorted(Comparator.comparing(Transaction::getValue).reversed()) // 내림차
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        tr2021.forEach(System.out::println);

        System.out.println();

        // 연습 2: 거래자가 근무하는 모든 도시를 중복 없이 나열
        // List<String>
        // 거래 목록에서 거래자들을 추출한 후에 거래자 안에 있는 도시 이름을 추출
        // filter : 10개 중에 조건에 맞는 3개를 필터링
        // map : 10개 중에 10개를 가정하는데 조건에 맞게 추출
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        cities.forEach(System.out::println);

        System.out.println();

        // 연습 3: Cambridge 에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬 (중복 제거)
        // List<Trader>
        // 거래 목록에서 거래자들 우선 추출 (map)
        List<Trader> cambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        cambridge.forEach(System.out::println);

        System.out.println();

        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로 오름차정렬하여 반환 (중복 제거)
        // List<String>
        List<String> names = transactions.stream()
                .map(transaction ->  transaction.getTrader().getName())
                .sorted()      // 정렬 리스트 대상이 String 이나 숫자타입이나 Comparator 를 안써도 알아서 정렬
                .distinct()
                .collect(Collectors.toList());
        System.out.println("names = " + names);
    }
}
