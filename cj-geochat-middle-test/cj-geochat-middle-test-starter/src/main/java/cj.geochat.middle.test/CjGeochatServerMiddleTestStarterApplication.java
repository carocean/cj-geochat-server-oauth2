package cj.geochat.middle.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cj.geochat.middle.test"})
@EnableDiscoveryClient
public class CjGeochatServerMiddleTestStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjGeochatServerMiddleTestStarterApplication.class, args);
    }

}
