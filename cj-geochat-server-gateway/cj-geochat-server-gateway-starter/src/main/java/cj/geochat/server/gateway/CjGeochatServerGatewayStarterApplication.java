package cj.geochat.server.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"cj.geochat.server.gateway"})
@EnableDiscoveryClient
public class CjGeochatServerGatewayStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjGeochatServerGatewayStarterApplication.class, args);
    }

}
