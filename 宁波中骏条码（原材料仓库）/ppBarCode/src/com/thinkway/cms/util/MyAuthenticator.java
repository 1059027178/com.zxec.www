package com.thinkway.cms.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
    String userName;
    String userPass;

    public MyAuthenticator() {
    }

    public MyAuthenticator(String userName, String userPass) {
            this.userName = userName;
            this.userPass = userPass;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(userName, userPass);
    }
}
