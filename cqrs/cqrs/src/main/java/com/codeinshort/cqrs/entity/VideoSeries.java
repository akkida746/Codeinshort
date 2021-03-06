package com.codeinshort.cqrs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "VIDEO_SERIES")
public class VideoSeries {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer volumes;

    @Column
    private BigDecimal cashValue;

    @Column
    private String genre;
}