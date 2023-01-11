//2023-01-10
package org.example.inherit;

import org.example.basic.Dancer;
import org.example.basic.Rapper;

public class StreetDancer extends Dancer
                    implements Rapper {

    public StreetDancer(String crewName, String myName) {       // Alt + Insert 단축키
        super(crewName, myName);
    }

    // 오버라이딩
    @Override       // @Override : 시그니처를 실수하지 않고 똑같이 맞췄는지 확인해줌 (안전한 코드)
    public void dance() {
        // super.dance();
        System.out.println("스트릿댄서만 비보잉을 합니다.");
    }

//    public void streetDance() {
//        super.dance();
//        System.out.println("스트릿댄서만 비보잉을 합니다.");
//    }

    @Override
    public void rap() {

    }
}
