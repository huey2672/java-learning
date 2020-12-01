package com.huey.learning.java.shiro.quickstart;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author huey
 */
public class ShiroTest {

    Subject currentUser;

    @Before
    public void prepare() {

        // create a realm
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("Huey", "123456", "admin");

        // create and set security manager
        SecurityManager securityManager = new DefaultSecurityManager(simpleAccountRealm);
        SecurityUtils.setSecurityManager(securityManager);

        // get the current user view
        currentUser = SecurityUtils.getSubject();

    }

    @Test
    public void testLoginSuccessfully() {

        // obtain the auth token
        AuthenticationToken token = new UsernamePasswordToken("Huey", "123456");

        // login with correct username and password
        currentUser.login(token);

        Assert.assertTrue(currentUser.isAuthenticated());

    }

    @Test(expected = UnknownAccountException.class)
    public void testUnknownAccountException() {

        AuthenticationToken token = new UsernamePasswordToken("NoName", "123456");

        // login with unknown username
        currentUser.login(token);

    }

    @Test(expected = IncorrectCredentialsException.class)
    public void testIncorrectCredentialsException() {

        // login with incorrect password
        AuthenticationToken token = new UsernamePasswordToken("Huey", "654321");

        currentUser.login(token);

    }

    @Test
    public void testHasRole() {

        AuthenticationToken token = new UsernamePasswordToken("Huey", "123456");

        currentUser.login(token);

        // test user has specified role
        Assert.assertTrue(currentUser.hasRole("admin"));

    }

    @Test
    public void testHasRoles() {

        AuthenticationToken token = new UsernamePasswordToken("Huey", "123456");

        currentUser.login(token);

        // test user has specified roles
        Assert.assertArrayEquals(new boolean[]{true, false},
                currentUser.hasRoles(Arrays.asList("admin", "guest")));

    }

    @Test
    public void testLogout() {

        AuthenticationToken token = new UsernamePasswordToken("Huey", "123456");

        currentUser.login(token);

        // test user is authenticated
        Assert.assertTrue(currentUser.isAuthenticated());

        currentUser.logout();

        // test user is authenticated again after logout
        Assert.assertFalse(currentUser.isAuthenticated());

    }

}
