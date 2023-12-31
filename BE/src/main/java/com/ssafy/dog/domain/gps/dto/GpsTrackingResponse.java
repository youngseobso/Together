package com.ssafy.dog.domain.gps.dto;

import java.time.LocalDateTime;

import com.ssafy.dog.domain.gps.entity.GpsPoints;
import com.ssafy.dog.domain.gps.entity.GpsTracking;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GpsTrackingResponse {

	private String id;
	private LocalDateTime trackingDate;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private GpsPoints gpsPoints;
	private String runningTime;

	@Builder
	public GpsTrackingResponse(String id, LocalDateTime trackingDate, LocalDateTime createdDate,
		LocalDateTime modifiedDate,
		GpsPoints gpsPoints, String runningTime) {
		this.id = id;
		this.trackingDate = trackingDate;
		this.gpsPoints = gpsPoints;
		this.runningTime = runningTime;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public static GpsTrackingResponse toResponse(GpsTracking gpsTracking) {
		return GpsTrackingResponse.builder()
			.id(gpsTracking.getId())
			.gpsPoints(gpsTracking.getGpsPoints())
			.trackingDate(gpsTracking.getTrackingDate())
			.runningTime(gpsTracking.getRunningTime())
			.createdDate(gpsTracking.getCreatedDate())
			.modifiedDate(gpsTracking.getModifiedDate())
			.build();
	}
}
