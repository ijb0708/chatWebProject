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
     * 토큰을 생성하기 위한 함수
     * @param userId 생성할 유저의 아이디
     * @return jwtToken
     */
    public String generateToken(String userId) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_MS);

        Claims claims = Jwts.claims()
                .setSubject("access_token")
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
     * @param token 토큰 값
     * @return 토큰 정보
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
     * 토큰 값의 유효성 체크 함수
     * @param token 토큰 값
     * @return 토큰값 유효여부 (boolean)
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
    
    /**
     *
     * @param token 토큰 값
     * @return
     */
    public String getPk(String token) {

        return (String) Jwts
                .parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("id");
    }

    /**
     *
     * @param token
     * @return
     */
    public Authentication getAuthentication(String token) {

        return new UsernamePasswordAuthenticationToken(getPk(token), "");
    }
}
