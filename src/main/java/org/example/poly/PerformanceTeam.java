package org.example.poly;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;

import java.util.ArrayList;
import java.util.List;

// 다형성의 원리 이용
public class PerformanceTeam {

//    private List<IdolDancer> dancers = new ArrayList<>();
    private List<Dancer> dancers = new ArrayList<>();       // 다형성

    // 팀의 댄서를 영입하는 메서드
    public void joinDancer(Dancer dancer) {
        dancers.add(dancer);

        System.out.println(dancer.getMyName() + "님이 팀에 가입했습니다.");
        System.out.println("현재 팀원 수:  " + dancers.size() + "명");
    }

    // 군무연습
    public void groupDance() {
        for (Dancer dancer : dancers) {     // iter 단축키
            dancer.dance();
        }
    }
}
