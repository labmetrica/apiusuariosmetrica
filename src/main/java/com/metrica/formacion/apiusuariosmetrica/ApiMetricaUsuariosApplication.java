package com.metrica.formacion.apiusuariosmetrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class ApiMetricaUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMetricaUsuariosApplication.class, args);
    }

}
