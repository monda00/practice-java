package com.example.sampleapispringboot;

import static org.assertj.core.api.Assertions.*;

import com.example.sampleapispringboot.controller.ItemController;
import com.example.sampleapispringboot.repo.ItemRepository;
import com.example.sampleapispringboot.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleApiSpringBootApplicationTests {

	@Autowired
	private ItemController itemController;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemService itemService;

	@Test
	void contextLoads() {
		assertThat(itemController).isNotNull();
		assertThat(itemRepository).isNotNull();
		assertThat(itemService).isNotNull();
	}
}
