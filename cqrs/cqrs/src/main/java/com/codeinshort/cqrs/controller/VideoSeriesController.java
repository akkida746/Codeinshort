package com.codeinshort.cqrs.controller;

import com.codeinshort.cqrs.command.AddVideoSeriesCommand;
import com.codeinshort.cqrs.command.FindAllVideoSeriesCommand;
import com.codeinshort.cqrs.dto.VideoSeriesDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.responsetypes.ResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video-series")
public class VideoSeriesController {

    private final CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    public VideoSeriesController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public void postNewVideoSeries(@RequestBody VideoSeriesDto videoSeriesDto) {
        commandGateway.send(
                AddVideoSeriesCommand.builder()
                        .name(videoSeriesDto.getName())
                        .volumes(videoSeriesDto.getVolumes())
                        .genre(videoSeriesDto.getGenre())
                        .cashValue(videoSeriesDto.getCashValue())
                        .build());
    }

    @GetMapping
    public List<VideoSeriesDto> gertAllVideoSeries() {
        return queryGateway.query(new FindAllVideoSeriesCommand(), ResponseTypes.multipleInstancesOf(VideoSeriesDto.class))
                .join();
    }
}
