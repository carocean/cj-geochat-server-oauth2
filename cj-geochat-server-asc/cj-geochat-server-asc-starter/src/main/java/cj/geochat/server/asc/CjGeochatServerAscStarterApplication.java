package cj.geochat.server.asc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cj.geochat.server.asc"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cj.geochat.server.asc")
public class CjGeochatServerAscStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjGeochatServerAscStarterApplication.class, args);
    }

}
