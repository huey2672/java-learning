package com.huey.learning.java.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author huey
 */
public class CustomRealm extends AuthorizingRealm {

    private Map<String, String> users = new HashMap<>();
    private Map<String, Set<String>> userRoles = new HashMap<>();
    private Map<String, Set<String>> rolePermissions = new HashMap<>();

    {

        users.put("zhangsan", "password");
        users.put("lisi", "password");
        users.put("wangwu", "password");

        userRoles.put("zhangsan", new HashSet<>(Arrays.asList("admin")));
        userRoles.put("lisi", new HashSet<>(Arrays.asList("editor")));
        userRoles.put("wangwu", new HashSet<>(Arrays.asList("author")));

        rolePermissions.put("admin", new HashSet<>(Arrays.asList("*")));
        rolePermissions.put("editor", new HashSet<>(Arrays.asList("articles:*")));
        rolePermissions.put("author", new HashSet<>(Arrays.asList("articles:compose", "articles:save")));

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken uToken = (UsernamePasswordToken) token;

        if (uToken.getUsername() == null
                || uToken.getUsername().isEmpty()
                || !users.containsKey(uToken.getUsername())) {

            throw new UnknownAccountException("username not found!");

        }

        return new SimpleAuthenticationInfo(
                uToken.getUsername(),
                users.get(uToken.getUsername()),
                getName());

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Set<String> roleNames = new HashSet<>();
        Set<String> permissions = new HashSet<>();

        principals.forEach(username -> {
            Set<String> roles = getRoleNamesForUser((String) username);
            roleNames.addAll(roles);
            permissions.addAll(getPermissions(roles));
        });

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;

    }

    private Set<String> getRoleNamesForUser(String username) {
        if (!userRoles.containsKey(username)) {
            throw new UnauthorizedException("username not found!");
        }

        return userRoles.get(username);
    }

    private Set<String> getPermissions(Collection<String> roleNames) {

        for (String role : roleNames) {
            if (!rolePermissions.containsKey(role)) {
                throw new UnauthorizedException("role not found!");
            }
        }

        Set<String> finalSet = new HashSet<>();
        for (String role : roleNames) {
            finalSet.addAll(rolePermissions.get(role));
        }

        return finalSet;

    }

}
