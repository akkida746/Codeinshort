package com.codeinshort.cqrs.command;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class AddVideoSeriesCommand {

    @TargetAggregateIdentifier
    private String id;

    private String name;

    private Integer volumes;

    private BigDecimal cashValue;

    private String genre;

}
