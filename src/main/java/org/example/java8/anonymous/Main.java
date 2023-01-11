//2023-01-11
package org.example.java8.anonymous;

// 실제 개발 시에는 Main 클래스 여러개 생성 금지
public class Main {

    // 내부클래스
    public static class SubCalculator implements Calculator {
        @Override
        public int operate(int n1, int n2) {
            return n1 - n2;
        }
    }

    public static void main(String[] args) {

        // ① 덧셈기능을 구현한 계산기 객체를 생성
        //new Calculator()        // -> 불가 : 인터페이스는 추상적이기때문에 구체적인 객체로 만들 수 없음 => AddCalculator [클래스 추가]
        Calculator addCal = new AddCalculator();
        System.out.println(addCal.operate(10, 20));

        // ② 뺄셈기능을 구현한 계산기 객체를 생성 --> 또 클래스 추가? NO! [내부클래스] 이용!(SubCalculator)
        SubCalculator subCal = new SubCalculator();
        System.out.println(subCal.operate(100, 20));

        // ③ 곱셈기능을 구현한 계산기 객체를 생성 --> 계속 내부 클래스 생성? NO! [익명클래스] 이용
        Calculator multiCal = new Calculator() {
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
        System.out.println(multiCal.operate(20, 5));

        // ④ 나눗셈의 몫을 구하는 계산기 객체를 생성 --> 코드를 더 줄이는 방법은? [람다] 이용
        Calculator divCal = (n1, n2) -> n1 / n2;
        System.out.println(divCal.operate(100, 50));

        //
        PowerOperator op = (n1, n2, cal) -> cal.operate(n1, n2);

        int r1 = op.power(50 , 60, ((n1, n2) -> n1 + n2));
        System.out.println("r1(+) = " + r1);
        
        int r2 = op.power(500, 30, ((n1, n2) -> n1 * n2));
        System.out.println("r2(*) = " + r2);
    }
}
