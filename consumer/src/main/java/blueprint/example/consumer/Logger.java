package blueprint.example.consumer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Component;

@Component
public class Logger {

	private static final Log log = LogFactoryUtil.getLog(Consumer.class);

	void info (String s) {
		log.info(s);
	}

	void info (Object o) {
		log.info(o);
	}

	void error (String s) {
		log.error(s);
	}



}
