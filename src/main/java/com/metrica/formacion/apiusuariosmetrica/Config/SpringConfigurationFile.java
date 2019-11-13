package com.metrica.formacion.apiusuariosmetrica.Config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.metrica.formacion.apiusuariosmetrica")
@EnableJpaRepositories("com.metrica.formacion.apiusuariosmetrica.dao")
@EnableTransactionManagement
@EnableDiscoveryClient
public class SpringConfigurationFile {

}
