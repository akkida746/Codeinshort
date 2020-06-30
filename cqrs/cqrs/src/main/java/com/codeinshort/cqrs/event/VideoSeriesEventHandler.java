package com.codeinshort.cqrs.event;

import com.codeinshort.cqrs.command.FindAllVideoSeriesCommand;
import com.codeinshort.cqrs.dto.VideoSeriesDto;
import com.codeinshort.cqrs.entity.VideoSeries;
import com.codeinshort.cqrs.repository.VideoSeriesRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ProcessingGroup("video-series")
public class VideoSeriesEventHandler {

    private final VideoSeriesRepository videoSeriesRepository;

    public VideoSeriesEventHandler(VideoSeriesRepository videoSeriesRepository) {
        this.videoSeriesRepository = videoSeriesRepository;
    }

    @EventHandler
    public void on(AddSeriesEvent event) {
        videoSeriesRepository.save(VideoSeries
                .builder()
                .name(event.getName())
                .volumes(event.getVolumes())
                .genre(event.getGenre())
                .cashValue(event.getCashValue())
                .build());
    }

    @QueryHandler
    public List<VideoSeriesDto> handle(FindAllVideoSeriesCommand query) {
        return videoSeriesRepository.findAll().stream().map(
                videoSeries -> VideoSeriesDto.builder()
                        .name(videoSeries.getName())
                        .volumes(videoSeries.getVolumes())
                        .cashValue(videoSeries.getCashValue())
                        .genre(videoSeries.getGenre())
                        .build()).collect(Collectors.toList());
    }

}
