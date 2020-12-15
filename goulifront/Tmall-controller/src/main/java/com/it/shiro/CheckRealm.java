package com.it.shiro;

import com.it.bean.Admin;
import com.it.bean.Permisson;
import com.it.service.AdminService;
import com.it.service.PermissonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CheckRealm extends AuthorizingRealm {

    @Autowired
    AdminService adminService;

    @Autowired
    PermissonService permissonService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if(authenticationToken.getPrincipal()==null){
            return null;
        }
        String admin_name = authenticationToken.getPrincipal().toString();
        Admin admin = adminService.GetAdminByAdminName(admin_name);
        if (admin==null)
        {
            return  null;
        }else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(admin_name, admin.getAdmin_password(), getName());
            return simpleAuthenticationInfo;
        }
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String admin_name = principalCollection.getPrimaryPrincipal().toString();

        Admin admin = adminService.GetAdminByAdminName(admin_name);

        Integer admin_id=admin.getAdmin_id();

        List<Permisson> funcs=permissonService.GetPermissonsByAdminId(admin_id,"func");

        //记录用户的所有角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();//权限信息

        for (Permisson permisson : funcs) {

            String code=permisson.getCode();
            log.info("当前用户:"+admin.getAdmin_name()+",具备权限是:"+code);
            simpleAuthorizationInfo.addStringPermission(code);
        }
        return simpleAuthorizationInfo;
    }


}
