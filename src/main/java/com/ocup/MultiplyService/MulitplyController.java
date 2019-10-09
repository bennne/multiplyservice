package com.ocup.MultiplyService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MulitplyController {

	@Value("${sumservice}")
	private String sumServiceUrl;
	
	@RequestMapping("/multiply")
	public String sum(@RequestParam(value = "val1", defaultValue = "0") double val1,
			@RequestParam(value = "val2", defaultValue = "0") double val2) {
		System.out.println("MULTIPLY: " + val1 + " * " + val2);

		RestTemplate restTemplate = new RestTemplate();
		double result = 0;
		for (double i = 0; i < val1; i++) {
			String servicecall = sumServiceUrl+"?val1=" + result+ "&val2=" + val2;
			System.out.println("CALL SUM SERVICE: " + servicecall);
			Double sumResult = restTemplate
					.getForObject(servicecall, Double.class);
			System.out.println("SUM RESULT: " + sumResult);
			result = sumResult;
		}
		System.out.println("MULTIPLY RESULT: " + result);
		return "The result of the multiply is" + result;
	}
}