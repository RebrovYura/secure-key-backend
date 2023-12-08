package com.securekey.securekeybackend;

import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

@Component
public class JWTCore {
    @Value("${secureKey.app.secret}")
    private String secret;

    @Value("${secureKey.app.lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication) {
        UserDetailImplementation userDetail = (UserDetailImplementation)authentication.getPrincipal();
        return Jwts.builder().setSubject((userDetail.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
