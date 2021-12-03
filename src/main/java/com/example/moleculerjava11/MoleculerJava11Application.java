package com.example.moleculerjava11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import services.moleculer.ServiceBroker;
import services.moleculer.config.ServiceBrokerConfig;
import services.moleculer.config.SpringRegistrator;
import services.moleculer.repl.LocalRepl;
import services.moleculer.transporter.RedisTransporter;

@SpringBootApplication
public class MoleculerJava11Application {

    public static void main(String[] args) {
        SpringApplication.run(MoleculerJava11Application.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public ServiceBroker getServiceBroker() {
        ServiceBrokerConfig config = new ServiceBrokerConfig();
        config.setNodeID("node1");

        RedisTransporter transporter = new RedisTransporter("redis://localhost:6379");

        config.setTransporter(transporter);
        return new ServiceBroker(config);
    }

    @Bean
    public SpringRegistrator getSpringRegistrator() {
        return new SpringRegistrator();
    }

    @Bean
    public LocalRepl getLocalConsole() {
        return new LocalRepl();
    }


}
