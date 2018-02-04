package com.therealdanvega.tech.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("techelevator")
@Data
public class TechElevetorProperties {

    private String welcomeMsg = "Hello, World!";

}
