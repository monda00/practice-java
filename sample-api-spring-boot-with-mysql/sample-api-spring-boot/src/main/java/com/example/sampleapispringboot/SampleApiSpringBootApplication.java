package com.example.sampleapispringboot;

import com.example.sampleapispringboot.model.Item;
import com.example.sampleapispringboot.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SampleApiSpringBootApplication implements CommandLineRunner {
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(SampleApiSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		itemRepository.save(new Item("itemA", "categoryA"));
		itemRepository.save(new Item("itemB", "categoryB"));
		itemRepository.save(new Item("itemC", "categoryC"));
		itemRepository.save(new Item("itemD", "categoryD"));
		itemRepository.save(new Item("itemE", "categoryE"));
	}
}
