//2023-01-10
package org.example.abs;

public abstract class Car {

    // 자동차의 필수 기능
    public abstract void brake();           // Sonata 에 brake 와 accel 함수 필수 (이름도 동일해야 함) -> why? brake 와 accel 이 abstract (추상화)

    public abstract void accel();
}
