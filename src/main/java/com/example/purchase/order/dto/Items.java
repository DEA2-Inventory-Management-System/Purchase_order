package com.example.purchase.order.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Items {
    private String  itemName;

    private double unitPrice;

    private List<Item> item = new ArrayList<>();


}