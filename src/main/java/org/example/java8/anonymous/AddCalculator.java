//2023-01-11
package org.example.java8.anonymous;

// 덧셈기능을 구현한 계산기
public class AddCalculator implements Calculator {

    @Override
    public int operate(int n1, int n2) {
        return n1 + n2;
    }
}
