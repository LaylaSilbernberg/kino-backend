package com.kino.kinobackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kino.kinobackend.controller.KinoController;
import com.kino.kinobackend.model.repository.dto.MovieDTO;
import com.kino.kinobackend.model.repository.dto.Rating;
import com.kino.kinobackend.model.service.KinoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(KinoController.class)
class KinoBackendControllerTests {

	private final MockMvc mockMvc;

	@MockBean
	private KinoService service;

	public KinoBackendControllerTests(@Autowired MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	private final MovieDTO mockMovie = new MovieDTO("Blade Runner",
			"1982",
			"R",
			"26 Jun 1982",
			"117 min",
			"Action, Drama, Sci-Fi",
			"Ridley Scott",
			"Hampton Fancher, David Webb Peoples, Philip K. Dick",
			"Harrison Ford, Rutger Hauer, Sean Young",
			"""
					A blade runner must pursue and terminate \
					four replicants who stole a ship in space \
					and have returned to Earth to find their creator.""",
			"English, German, Cantonese, Japanese, Hungarian, Arabic, Korean",
			"United States, United Kingdom",
			"Nominated for 2 Oscars. 13 wins & 21 nominations total",
			"https://m.media-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
			new Rating[]{new Rating("Internet Movie Database", "8.1/10"),
			new Rating("Rotten Tomatoes", "88%"),
			new Rating("Metacritic", "84/100")},
			"09 Jun 2013",
			"$32,914,489");

	@Test
	void controllerShouldReturnMovieDtoWhenGetBySearchIsCalled() throws Exception {
		when(service.getMovieByTitle(Mockito.anyString())).thenReturn(mockMovie);
		String json = this.mockMvc
				.perform(MockMvcRequestBuilders
						.get("/api/kino/Blade Runner"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.Title").value("Blade Runner"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.Director").value("Ridley Scott"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();

		MovieDTO result = new ObjectMapper().readValue(json, MovieDTO.class);
		assertThat(result).usingRecursiveComparison().isEqualTo(mockMovie);
	}


}
