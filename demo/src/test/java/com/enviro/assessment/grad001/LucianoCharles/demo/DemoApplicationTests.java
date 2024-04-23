package com.enviro.assessment.grad001.LucianoCharles.demo;

import com.enviro.assessment.grad001.LucianoCharles.demo.controller.WasteController;
import com.enviro.assessment.grad001.LucianoCharles.demo.model.WasteCategories;
import com.enviro.assessment.grad001.LucianoCharles.demo.service.WasteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;


@WebMvcTest(WasteController.class)
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WasteService wasteService;

	@Test
	public void testGetAllCategories() throws Exception {
		WasteCategories category = new WasteCategories();
		when(wasteService.getAllCategories()).thenReturn(Collections.singletonList(category));

		mockMvc.perform(MockMvcRequestBuilders.get("/waste-categories")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].category").value(category.getCategory()));
	}

	@Test
	public void testCreateCategory() throws Exception {
		WasteCategories category = new WasteCategories("Test Category", "Test Disposal Tip", "Test Recycling Tip");
		when(wasteService.createWaste(Mockito.any())).thenReturn(category);

		mockMvc.perform(MockMvcRequestBuilders.post("/waste-categories")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"category\": \"Test Category\", \"disposalTip\": \"Test Disposal Tip\", \"recyclingTip\": \"Test Recycling Tip\"}"))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.category").value(category.getCategory()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.disposalTip").value(category.getDisposalTip()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.recyclingTip").value(category.getRecyclingTip()));
	}


	@Test
	public void testGetDisposalTip() throws Exception {

		when(wasteService.getDisposalTip(1L)).thenReturn("Test Disposal Tip");

		mockMvc.perform(MockMvcRequestBuilders.get("/waste-categories/1/disposal-tip"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Test Disposal Tip"));
	}

	@Test
	public void testGetRecyclingTip() throws Exception {
		when(wasteService.getRecyclingTip(1L)).thenReturn("Test Recycling Tip");

		mockMvc.perform(MockMvcRequestBuilders.get("/waste-categories/1/recycling-tip"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Test Recycling Tip"));
	}
	@Test
	public void testDeleteCategory() throws Exception {
		Long categoryId = 1L;
		mockMvc.perform(MockMvcRequestBuilders.delete("/waste-categories/{id}", categoryId))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
}