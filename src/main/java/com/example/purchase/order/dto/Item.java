package com.example.purchase.order.dto;
0
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    private String itemColor;

    private int quantity;


}