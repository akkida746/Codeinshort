package com.codeinshort.cqrs.aggregate;

import com.codeinshort.cqrs.command.AddVideoSeriesCommand;
import com.codeinshort.cqrs.event.AddSeriesEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Slf4j
@NoArgsConstructor
@Aggregate
@Data
public class VideoSeriesAggregate {

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public VideoSeriesAggregate(AddVideoSeriesCommand command) {
        apply(AddSeriesEvent.builder()
                .id(UUID.randomUUID().toString())
                .cashValue(command.getCashValue())
                .genre(command.getGenre())
                .name(command.getName())
                .volumes(command.getVolumes()).build()
        );
    }

    @EventSourcingHandler
    public void on(AddSeriesEvent event) {
        this.id = event.getId();
    }

}
