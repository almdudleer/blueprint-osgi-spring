package blueprint.example.dateproducer;


import java.util.Date;

import org.springframework.stereotype.Component;

import blueprint.example.producer.api.Producer;

@Component
public class ProducerImpl implements Producer {

	@Override
	public String produceString() {
		return new Date().toString();
	}

}
