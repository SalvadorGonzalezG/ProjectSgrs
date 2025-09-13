package com.projectRs.sgrs;

import com.projectRs.sgrs.dto.PageRequest;
import com.projectRs.sgrs.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgrsApplication implements CommandLineRunner {

	@Autowired
	private PageService pageService; // ID Abstraction

	public static void main(String[] args) {
		SpringApplication.run(SgrsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var req = PageRequest
				.builder()
				//.userId(4L)
				.title("Pagere")
				.build();

		//var response = this.pageService.create(req);
		var res = this.pageService.update(req,"User2 Page");
		//System.out.println(response);
		System.out.println(res);

	}
}
