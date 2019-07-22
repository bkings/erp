package com.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Calendar;
import java.util.Date;

public class JWTToken {

private static String signWith = "MsWarePhoenixsolutions@SpringBoot.com.erp";
private String userId, userName, userType, branch;
private boolean status;

public JWTToken() {
}


public JWTToken(String Authorization) {
    status = false;
    String token = Authorization.substring(7);
    try {
        final Claims claims = Jwts.parser().setSigningKey(signWith).parseClaimsJws(token).getBody();
        status = true;
        userId = claims.getId();
        userName = claims.getIssuer();
         branch = claims.getSubject();
        userType = claims.getAudience();      

    } catch (final SignatureException e) {
        userId = "";
        userName = "";
        userType = "";
        branch = "";
        status = false;

    }
}

public String getUserId() {
    return userId;
}

public void setUserId(String userId) {
    this.userId = userId;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public boolean isStatus() {
    return status;
}

public void setStatus(boolean status) {
    this.status = status;
}

public String getUserType() {
    return userType;
}

public void setUserType(String userType) {
    this.userType = userType;
}

public String getBranch() {
    return branch;
}

public void setBranch(String branch) {
    this.branch = branch;
}

@Override
public String toString() {
    return "{\"userId\":\"" + userId + "\",\"userType\":\"" + userType + "\",\"branch\":\"" + branch + "\",\"userName\":\"" + userName + "\"}";
}
}
