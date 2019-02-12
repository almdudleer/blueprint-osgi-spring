package blueprint.example.consumer;

import blueprint.example.producer.api.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Consumer {

	@Autowired
	private Logger log;
	@Autowired
	private Producer producer;

	@PostConstruct
	public void start() {
		log.info("_______________" + producer.produceString() + "_______________");

	}
	
}
