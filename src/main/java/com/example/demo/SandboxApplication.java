package com.example.demo;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class SandboxApplication {

    private static final String INIT_METHOD = "start";
    private static final String DESTROY_METHOD = "stop";
    private static final String[] ARGS = new String[]{"-tcp", "-tcpAllowOthers", "-tcpPort", "9092"};

    @Value("${test.foo}")
    private String fooValue;

    @Bean(initMethod = INIT_METHOD, destroyMethod = DESTROY_METHOD)
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer(ARGS);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SandboxApplication.class, args);
        SandboxApplication sandboxApplication = run.getBean(SandboxApplication.class);
        System.out.println(sandboxApplication.getFooValue());
    }

    public String getFooValue() {
        return fooValue;
    }
}
