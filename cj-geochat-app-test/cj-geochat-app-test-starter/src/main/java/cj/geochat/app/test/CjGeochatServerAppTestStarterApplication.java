package cj.geochat.app.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cj.geochat.app.test"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cj.geochat.app.test")
public class CjGeochatServerAppTestStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjGeochatServerAppTestStarterApplication.class, args);
    }

}
