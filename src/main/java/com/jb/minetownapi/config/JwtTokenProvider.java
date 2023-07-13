package com.jb.minetownapi.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

//    @Value("{jwt.expiration.ms}")
    private final long EXPIRATION_MS = 144000L;
    
    /**
     *
     * @param userId
     * @return
     */
    public String generateToken(String userId) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_MS);

        Claims claims = Jwts.claims()
                .setSubject("asccess_token")
                .setIssuedAt(now) //시작시간
                .setExpiration(expiryDate); // 만료시간

        claims.put("id", userId);

        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    
    /**
     *
     * @param token
     * @return
     */
    public String getTokenInfo(String token) {
        return Jwts
                .parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }
    
    /**
     *
     * @param token
     * @return
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    public String getPk(String token) {

        return (String) Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("id");
    }

    /**
     *
     * @param token
     * @return
     */
    public Authentication getAuthentication(String token) {

        return new UsernamePasswordAuthenticationToken(getPk(token), "");
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authentication");
    }
}
