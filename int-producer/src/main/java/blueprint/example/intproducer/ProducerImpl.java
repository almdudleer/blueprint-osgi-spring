package blueprint.example.intproducer;


import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

import blueprint.example.producer.api.Producer;

@Component
public class ProducerImpl implements Producer {
	
	private Random random = new Random(new Date().getTime());
	
	@Override
	public String produceString() {
		return String.valueOf(random.nextInt());
	}

}
