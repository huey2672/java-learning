package com.huey.learning.java.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huey
 */
public class CustomRealmSample {

    static final Logger log = LoggerFactory.getLogger(CustomRealmSample.class);
    static final String DEFAULT_USERNAME = "zhangsan";
    static final String DEFAULT_PASSWORD = "password";

    public static void main(String[] args) throws Exception {

        // create a custom realm
        Realm realm = new CustomRealm();

        // create and set security manager
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        SecurityUtils.setSecurityManager(securityManager);

        // get the current user view
        Subject currentUser = SecurityUtils.getSubject();

        // obtain the auth token
        String username = args.length > 1 ? args[0] : DEFAULT_USERNAME;
        String password = args.length > 1 ? args[1] : DEFAULT_PASSWORD;
        AuthenticationToken token = new UsernamePasswordToken(username, password);

        // login with correct username and password
        currentUser.login(token);

        // welcome the current user based on role
        if (currentUser.hasRole("admin")) {
            log.info("Welcome, {}! You are an admin.", username);
        }
        else if (currentUser.hasRole("editor")) {
            log.info("Welcome, {}! You are an editor!", username);
        }
        else if (currentUser.hasRole("author")) {
            log.info("Welcome, {}! You are an author!", username);
        }
        else {
            log.info("Welcome, {}! You are a guest!", username);
        }

        // what the current user is permitted to do in the system
        if (currentUser.isPermitted("articles:compose")) {
            log.info("You can compose an article");
        }
        else {
            log.info("You are not permitted to compose an article!");
        }

        if (currentUser.isPermitted("articles:save")) {
            log.info("You can save articles");
        }
        else {
            log.info("You can not save articles");
        }

        if (currentUser.isPermitted("articles:publish")) {
            log.info("You can publish articles");
        }
        else {
            log.info("You can not publish articles");
        }

        currentUser.logout();

    }

}
