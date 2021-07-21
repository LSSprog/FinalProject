package marcet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableFeignClients
@SpringBootApplication
public class MarcetFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarcetFrontApplication.class, args);
    }
}
