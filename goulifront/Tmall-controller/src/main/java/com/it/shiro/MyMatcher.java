package com.it.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;

public class MyMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取出用户的原始密码
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        //调用加密算法 --密文(用户输入的密码)
        String pwd = encrypt(String.valueOf(passwordToken.getPassword()));
        //数据库中存储的密码(密文)
        String mysqlpwd = (String)info.getCredentials();
        return this.equals(pwd,mysqlpwd);
    }

    private String encrypt(String data){
        String sha384Hex = new Sha384Hash(data).toBase64();
        return sha384Hex;
    }
    public static void main(String[] args) {
        String encrypt = new MyMatcher().encrypt("admin");
        System.out.println(encrypt);
    }
}
