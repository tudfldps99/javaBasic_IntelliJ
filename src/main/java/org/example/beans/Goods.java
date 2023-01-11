//2023-01-11
package org.example.beans;

import java.util.Objects;

public class Goods extends Object {

    // 필드를 설계할 때 private, protected 제한자를 사용
    // default 값이 숫자(long)로 들어오고 싶지 않으면 wrapper 타입(Long) 으로 표현
    private final Long goodsId;        // 상품번호
    private String goodsName;   // 상품명
    private Integer price;      // 상품가격

    // 기본 생성자(파라미터 없음)는 필수 - (파라미터가 있는) 생성자가 하나라도 존재하면 기본 생성자는 자동으로 안만들어줌
    public Goods() {
        this.goodsId = 1L;
    }

    public Goods(String goodsName, int price) {
        this();
        this.goodsName = goodsName;
        this.price = price;
    }


    // 변수 선언 시 final 이 들어가있으면 setter 필요 X
    // setter, getter 는 상황에 따라 선택
    public void setPrice(Integer price) {
        this.price = price;
    }

//    public void setGoodsId(Long goodsId) {
//        this.goodsId = goodsId;
//    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Integer getPrice() {
        return price;
    }

    // toString 재정의
    @Override
    public String toString() {
        return String.format("상품번호: %d, 상품명: %s, 상품가격: %d원", goodsId, goodsName, price);
    }

    // to 만 입력 한 후 '마법사로 생성' 클릭 시 다음과 같이 자동으로 작성됨
//    @Override
//    public String toString() {
//        return "Goods{" +
//                "goodsId=" + goodsId +
//                ", goodsName='" + goodsName + '\'' +
//                ", price=" + price +
//                '}';
//    }

    // equals 재정의 (중복객체 확인) --> equals overriding 해주면 hashcode 도 overriding 필요
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId)
                    && Objects.equals(goodsName, goods.goodsName)
                    && Objects.equals(price, goods.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, price);
    }
}
