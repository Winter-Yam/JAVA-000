package my.homework.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "my.homework.mq")
public class MyQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyQueueApplication.class, args);
	}

}
