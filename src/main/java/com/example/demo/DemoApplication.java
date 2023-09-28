package com.example.demo;

import com.example.demo.Model.Book;
import com.example.demo.Model.Review;
import com.example.demo.Repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(BookRepository bookRepository){
		return args -> {
			Book got = new Book("got","GRRM",4000);
			Review review = new Review("great","greater");
			got.setReviews((List.of(review)));
			bookRepository.save(got);
		};
	}


}
