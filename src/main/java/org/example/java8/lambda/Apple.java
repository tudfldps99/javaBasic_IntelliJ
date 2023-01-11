//2023-01-11
package org.example.java8.lambda;

import lombok.*;

// lombok 이용
@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Apple {
    private int weight;     // 무게
    private Color color;    // 색상
}
