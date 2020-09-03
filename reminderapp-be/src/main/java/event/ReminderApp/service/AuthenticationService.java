package event.ReminderApp.service;

import io.jsonwebtoken.SignatureAlgorithm;
import event.ReminderApp.dao.UserInterface;
import event.ReminderApp.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import java.util.Date;

@Service
public class AuthenticationService {

    public final UserInterface userInterface;
    public final UserService userService;

    private static final String
            SECRET_KEY = "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_" +
            "o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPB" +
            "ctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY" +
            "0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";

    @Autowired
    public AuthenticationService(@Qualifier("PersonDatabase") UserInterface userInterface, UserService userService) {
        this.userInterface = userInterface;
        this.userService = userService;
    }

    public String Authenticate(User user) throws Exception {

        User dbUser =  userInterface.getUserByEmail(user.getUserEmail()).get();

        if(user.getUserEmail().compareTo(dbUser.getUserEmail()) != 0 ||
                !userService.passwordEncoder().matches(user.getUserPassword(), dbUser.getUserPassword())){
            throw new Exception("Failed to authenticate");
        }
        return createJWT(String.valueOf(dbUser.getUserId()), dbUser.getUserName(), dbUser.getUserEmail(),86400000);
    }

    public String createJWT(String id, String issuer, String subject, long ttlMillis) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    public Claims decodeJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
    }
    
}

