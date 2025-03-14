package com.unique.rule.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * date:2025/1/26 13:20
 * author: haohaounique@163.com
 */
@SpringBootApplication(scanBasePackages = "com.unique")
@EnableFeignClients
@EnableDiscoveryClient
public class RuleCheckApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuleCheckApplication.class, args);
    }
}
