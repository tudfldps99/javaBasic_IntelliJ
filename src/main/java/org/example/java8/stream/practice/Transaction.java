//2023-01-11
package org.example.java8.stream.practice;

import lombok.*;

// 거래 내역
@Getter
@RequiredArgsConstructor
public class Transaction {
    private final Trader trader; // 거래자
    private final int year; // 거래연도
    private final int value; // 거래금액

    @Override
    public String toString() {
        return String.format("{%s, year: %d, value: %d}", trader, year, value);
    }
}
