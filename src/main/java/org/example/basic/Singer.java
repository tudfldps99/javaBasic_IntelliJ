package org.example.basic;

public interface Singer {       // interface 로 쓰면 밑의 코드에 public abstract 가 자동화됨.

    // 노래를 부를 때는 언제나 sing 이도록 추상화로 설계 (abstract)
    //public abstract void sing();

    void sing();
}
