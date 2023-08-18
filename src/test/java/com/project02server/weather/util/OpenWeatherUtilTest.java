package com.project02server.weather.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.project02server.weather.dto.restTemplate.forcastResponse.ForecastResponse;
import com.project02server.weather.dto.restTemplate.weatherResponse.CurrentWeatherResponse;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherUtilTest {


	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private OpenWeatherUtil openWeatherUtil;

	@Test
	@DisplayName("기상예측정보 반환 성공")
	public void testGetForeCastByCoordinate() {

		//given
		ForecastResponse mockResponse = new ForecastResponse();

		//when
		when(restTemplate.getForEntity(anyString(), any()))
			.thenReturn(ResponseEntity.ok(mockResponse));

		ForecastResponse forecastResponse = openWeatherUtil.getForeCastByCoordinate(anyString(), anyString());

		//then
		assertNotNull(forecastResponse);

	}

	@Test
	@DisplayName("현재날씨정보 반환 성공")
	public void testGetCurrentWeather() {

		// given
		CurrentWeatherResponse mockResponse = new CurrentWeatherResponse();

		// when
		when(restTemplate.getForEntity(anyString(), any()))
			.thenReturn(ResponseEntity.ok(mockResponse));

		CurrentWeatherResponse response = openWeatherUtil.getCurrentWeather(anyString(), anyString());

		//then
		assertNotNull(response);
	}
}