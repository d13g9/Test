package com.Test.Test.com.Test.Test;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		
		RESTAPI restapi = new RESTAPI();
		Result result = restapi.doRequest(null,"https://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search");
		
		result.getLo().forEach(e -> {
			System.out.println(e);
		});
		
		result.getUrl_tornada().forEach(e -> {
			System.out.println(e);
		});
	
	}

}
