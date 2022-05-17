package cn.limitless.springcloud_eureka_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaRegistryApplication.class, args);
    }

}
