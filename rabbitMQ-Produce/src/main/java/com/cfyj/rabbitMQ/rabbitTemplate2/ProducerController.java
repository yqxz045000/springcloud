package com.cfyj.rabbitMQ.rabbitTemplate2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.rabbitMQ.carrier.LogCarrier;
import com.cfyj.rabbitMQ.rabbitTemplate2.serivce.ProduceService;

@RestController
@RequestMapping("web2")
public class ProducerController {
	
	@Autowired
	private ProduceService produceService;
	
	@RequestMapping(value = "/direct/error", method = RequestMethod.GET)
    public void direct_error(String content) {
		LogCarrier contract = new LogCarrier();
		contract.setDateCreated(new Date());
		contract.setId(12L);
		contract.setName("direct-error");
		List<String> strList = new ArrayList<>();
		strList.add("liu");
		strList.add("test str");
		contract.setTestStrList(strList);
		produceService.sendDirect_error(contract);  
    }
	
	@RequestMapping(value = "/topic/error", method = RequestMethod.GET)
    public void topic_error(String content) {
		LogCarrier contract = new LogCarrier();
		contract.setDateCreated(new Date());
		contract.setId(12L);
		contract.setName("topic-error");
		List<String> strList = new ArrayList<>();
		strList.add("liu");
		strList.add("test str");
		contract.setTestStrList(strList);
		produceService.sendTopic_error(contract);  
    }
	
	@RequestMapping(value = "/topic/info", method = RequestMethod.GET)
    public void topic_info(String content) {
		LogCarrier contract = new LogCarrier();
		contract.setDateCreated(new Date());
		contract.setId(12L);
		contract.setName("topic-info");
		List<String> strList = new ArrayList<>();
		strList.add("liu");
		strList.add("test str");
		contract.setTestStrList(strList);
		produceService.sendTopic_error(contract);  
    }
	

}
