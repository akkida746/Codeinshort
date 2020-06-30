package com.codeinshort.cqrs.repository;

import com.codeinshort.cqrs.entity.VideoSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoSeriesRepository extends JpaRepository<VideoSeries, Long> {
}
