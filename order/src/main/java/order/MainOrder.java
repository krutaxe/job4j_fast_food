package order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EntityScan(basePackages = {"domain.model"})
public class MainOrder {

    public static void main(String[] args) {
        SpringApplication.run(MainOrder.class, args);
        System.out.println("http://localhost:8080/api");
    }
}
