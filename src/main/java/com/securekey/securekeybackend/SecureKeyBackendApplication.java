package com.securekey.securekeybackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecureKeyBackendApplication {

	private JWTCore jwtCore;

	public void setJwtCore(JwtCore jwtCore) {
		this.jwtCore = jswtCore;
	}

	public static void main(String[] args) {
		SpringApplication.run(SecureKeyBackendApplication.class, args);
	}

}
