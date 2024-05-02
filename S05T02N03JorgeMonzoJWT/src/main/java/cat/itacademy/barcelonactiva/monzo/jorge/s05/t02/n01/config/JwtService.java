package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.security.Key;

@Service
public class JwtService {

    private static final String SECRET_KEY = "18C85BD7369C09B7F7F402EABC33B71BC0B938CAEE9E6E6C507290D06CF6DF7C";

    public String generateToken (UserDetails userDetails){
        return generateToken (new HashMap<>(),userDetails);
    }

    public String generateToken(Map<String, Object> extracClaims, UserDetails userDetails){
        return Jwts.builder().setClaims(extracClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60 *24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserName (String token) {
        return getClaim (token, Claims::getSubject);
    }

    public <T> T getClaim (String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims (String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).
                build().parseClaimsJws(token).getBody();
    }
    private Key getSignInKey (){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public boolean validateToken (String token, UserDetails userDetails){
        final String username =  getUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    private boolean isTokenExpired (String token){
        return getExpiration(token).before(new Date());
    }
    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }
}
