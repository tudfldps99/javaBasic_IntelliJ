//2023-01-10
package org.example.inherit;

import org.example.basic.Dancer;
import org.example.basic.Rapper;
import org.example.basic.Singer;

public class IdolDancer extends Dancer      // 상속 - 객체를 2개 만들어 연결하는 역할
        implements Singer, Rapper {        //  다중상속이 불가능하므로 interface 로 (interface 는 여러개 사용 가능)

    private int numberOfFan;        // 팬의 수

    // 생성자를 하나도 선언하지 않으면 기본 생성자가 자동으로 만들어짐 (하나라도 생성하면 기본 생성자는 안만들어짐)
//    public IdolDancer() {
//        super();
//    }

    // 두번째 생성자를 사용하고 싶다면 아래와 같이 작성
    public IdolDancer(String crewName, String myName) {
        super(crewName, myName);
        this.numberOfFan = 10;

        System.out.println("idol dancer 생성됨");      //  sout 으로 System.out.println 자동생성
    }

    // 오버라이딩 : 부모의 메서드를 재정의
    // - 부모의 메서드 시그니처(이름, 리턴타입, 파라미터)를 똑같이 맞춰야 함
    @Override       // @Override : 시그니처를 실수하지 않고 똑같이 맞췄는지 확인해줌 (안전한 코드)
    public void dance() {
//        super.dance();
        wink();
    }

//    public void idolDance() {
//        super.dance();
//        wink();
//    }

    private void wink() {           // IdolDancer 의 단독 기능
        System.out.println("아이돌댄서만 윙크 합니다.");
    }

    @Override
    public void sing() {

    }

    @Override
    public void rap() {

    }
}
