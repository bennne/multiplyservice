package com.ocup.MultiplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MulitplyController {
	Logger logger = LoggerFactory.getLogger(MulitplyController.class);

	@RequestMapping("/multiply")
	public Double sum(@RequestParam(value = "val1", defaultValue = "0") double val1,
			@RequestParam(value = "val2", defaultValue = "0") double val2) {
		logger.debug("Multiply: " + val1 + " * " + val2);
		System.out.println("Multiply: " + val1 + " * " + val2);

		RestTemplate restTemplate = new RestTemplate();
		double result = 0;
		for (double i = 0; i < val1; i++) {
//			result = restTemplate
//					.getForObject("http://sum-calculator.apps.ca-central-1.starter.openshift-online.com/sum?val1=" + result
//							+ "&val2=" + val2 + "", Double.class);
			result = restTemplate
					.getForObject("http://172.30.146.95:8080/sum?val1=" + result
							+ "&val2=" + val2 + "", Double.class);
//			result = restTemplate.getForObject("http://localhost:8080/sum?val1=" + result + "&val2=" + val2 + "",
//					Double.class);
		}
		return result;
	}
}