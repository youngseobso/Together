package com.ssafy.dog.domain.gps.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dog.common.api.Api;
import com.ssafy.dog.domain.gps.dto.GpsTrackingDataResponse;
import com.ssafy.dog.domain.gps.dto.GpsTrackingDeleteRequest;
import com.ssafy.dog.domain.gps.dto.GpsTrackingResponse;
import com.ssafy.dog.domain.gps.dto.GpsTrackingSaveRequest;
import com.ssafy.dog.domain.gps.service.GpsTrackingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GpsTrackingController {

	private final GpsTrackingService gpsTrackingService;

	@PostMapping("/gps")
	public Api<GpsTrackingResponse> saveGpsDate(@RequestBody GpsTrackingSaveRequest request) {
		GpsTrackingResponse response = gpsTrackingService.saveGpsTrackingData(request);
		return Api.ok(response);
	}

	@GetMapping("/gps/{userLoginId}")
	public Api<GpsTrackingDataResponse> getAllGpsTrackingData(
		@PathVariable(name = "userLoginId") String userLoginId,
		@RequestParam(name = "order", defaultValue = "desc") String order,
		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "5") int size) {
		GpsTrackingDataResponse gpsTrackingResponse = gpsTrackingService.findTrackingDataByUserLoginId(
			userLoginId, page, size, order);
		return Api.ok(gpsTrackingResponse);
	}

	@GetMapping("/gps")
	public Api<GpsTrackingDataResponse> getAllMyGpsTrackingData(
		@RequestParam(name = "order", defaultValue = "desc") String order,
		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "5") int size) {
		GpsTrackingDataResponse gpsTrackingResponse = gpsTrackingService.findTrackingDataByUserLoginId(
			null, page, size, order);
		return Api.ok(gpsTrackingResponse);
	}

	@DeleteMapping("/gps")
	public Api<Boolean> deleteTrackingRecord(@RequestBody GpsTrackingDeleteRequest request) {
		return Api.ok(gpsTrackingService.deleteTrackingRecord(request));
	}
}
