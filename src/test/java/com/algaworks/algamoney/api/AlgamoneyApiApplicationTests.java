package com.algaworks.algamoney.api;

import com.algaworks.algamoney.api.configs.DataSourceConfig;
import com.algaworks.algamoney.api.controllers.CategoryController;
import com.algaworks.algamoney.api.producers.ApplicationPropertiesProducer;
import com.algaworks.algamoney.api.repositories.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationPropertiesProducer.class, DataSourceConfig.class})
@WebMvcTest(controllers = CategoryController.class)
public class AlgamoneyApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryRepository categoryRepository;

	@Test
	public void codeByCategoryTest() throws Exception {

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/categories"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
