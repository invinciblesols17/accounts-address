package com.solstice.lab4.accountsaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountsAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsAddressApplication.class, args);
	}
}
