package org.example.basic;

import static org.example.basic.DanceLevel.*;

public abstract class Dancer extends Object{     // 상속(extends)이 이루어지지 않을때는 자동으로 extends Object 가 붙음 ==> 자바의 최상위 클래스는 Object 클래스임을 알 수 있음
    // abstract : 추상화

    private final String crewName;        // 팀의 이름      ( final :  필수 불변값 -- 초기화 필요 : 생성자로도 OK )
    private final String myName;          // 내 이름

     private DanceLevel level = BEGINNER;               // 춤 수준 (전문가, 중수, 하수, 초보자)     ( 타입을 문자열(String)으로 잡지 말고, 열거형 타입으로 )

    // 스트레칭 여부
    private boolean stretch;

    // 유연성 여부
    private boolean flexible;

    // 생성자 : 객체가 처음 생성될 때 호출되는 메서드
    public Dancer() {       // 기본생성자 선언
//        this.crewName = "기본크루";
//        this.myName = "이름없음";

        // 위의 두줄 표현
        this("기본크루", "이름없음");       // this : mySelf
    }
    public Dancer(String crewName, String myName) {
        this.crewName = crewName;
        this.myName = myName;

        System.out.println("그냥 dancer 생성됨");
/*
        // 상단에 `import static java.lang.Math.*` 를 추가해주면 Math.random() 대신 random()으로 작성 가능 (식별자 명시할 필요 X)
        Math.random();
        Math.ceil(1.1 * Math.PI);

        // 상단에 `import static java.lang.System.*` 를 추가해주면 System.out.println() 대신 out.println()으로 작성 가능 (식별자 명시할 필요 X)
        System.out.println();
*/
    }

    // 스트레칭
    private void stretch() {        // 자동화 시키기 위해 private 로 설정
        System.out.println(myName + "님이 스트레칭합니다.");
        this.stretch = true;
    }

    // 다리찢기
    private void makeFlexible() {       // 자동화 시키기 위해 private 로 설정
        if (!stretch) {
            System.out.println("스트레칭 안해서 죽었습니다.");
            return;
        }
        System.out.println(myName + "님이 유연성 운동을 합니다.");
        this.flexible = true;
    }

    // 춤추기
//    public void dance() {
//
//        // 캡슐화
//        stretch();
//        makeFlexible();
//
//        if (!flexible) {
//            System.out.println("유연성 운동 안해서 죽었습니다.");
//            return;
//        }
//        System.out.println(myName + "님이 춤을 춥니다.");
//    }

    // 추상화
    public abstract void dance();

    public String getCrewName() {
        return crewName;
    }

    public String getMyName() {
        return myName;
    }
}
