package com.example.purchase.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDto {
    private String po;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    private List<Items> items = new ArrayList<>();



}