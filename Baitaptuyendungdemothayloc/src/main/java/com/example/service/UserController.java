//package com.example.service;
//
//import com.example.dto.LoginDto;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    @PostMapping("/login")
//    public LoginDto login(@RequestParam("account") String username, @RequestParam("password") String pwd) {
//
//        String token = getJWTToken(username);
//        LoginDto loginDto = new LoginDto();
//        loginDto.setAccount(username);
//        loginDto.setPassword(token);
//        return loginDto;
//
//    }
//    private String getJWTToken(String username) {
//        String secretKey = "mySecretKey";
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList("ROLE_USER");
//
//        String token = Jwts
//                .builder()
//                .setId("softtekJWT")
//                .setSubject(username)
//                .claim("authorities",
//                        grantedAuthorities.stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .collect(Collectors.toList()))
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 600000))
//                .signWith(SignatureAlgorithm.HS512,
//                        secretKey.getBytes()).compact();
//
//        return "Bearer " + token;
//    }
//}
