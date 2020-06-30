package com.codeinshort.cqrs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoSeriesDto {

    private String name;

    private Integer volumes;

    private BigDecimal cashValue;

    private String genre;
}
