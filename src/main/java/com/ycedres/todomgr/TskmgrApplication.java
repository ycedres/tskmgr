package com.ycedres.todomgr;

import com.ycedres.todomgr.model.Task;
import com.ycedres.todomgr.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TskmgrApplication {

	private static final Logger log = LoggerFactory.getLogger(TskmgrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TskmgrApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(TaskRepository repository) {
		return (args) -> {
			repository.save(new Task("do something 1"));
			repository.save(new Task("do something 2"));

			log.info("Find All:");
			for (Task t : repository.findAll()) {
				log.info(t.getDescription());
			}
		};
	}
}
