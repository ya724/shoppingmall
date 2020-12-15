package com.it.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.it.shiro.CheckRealm;
import com.it.shiro.MyMatcher;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 01-自定义Realm完成认证和授权,示例化CheckRealm对象，放入SpringIOC容器
     * @return
     */
    @Bean(name = "checkRealm")
    public CheckRealm getRealm(@Qualifier("credentialsMatcher") CredentialsMatcher credentialsMatcher){

        CheckRealm checkRealm = new CheckRealm();
        checkRealm.setCredentialsMatcher(credentialsMatcher);
        return checkRealm;
    }

    @Bean("credentialsMatcher")
    public CredentialsMatcher credentialsMatcher(){
        return new MyMatcher();
    }

    @Bean(name="defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("checkRealm") CheckRealm checkRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //注入自定义myRealm
        defaultWebSecurityManager.setRealm(checkRealm);
        //注入自定义cacheManager,启用缓存管理器
        defaultWebSecurityManager.setCacheManager(cacheManager());
        return defaultWebSecurityManager;
    }


    /**
     * 03-创建ShiroFilterFactoryBean  Shiro过滤器工厂
     * 进行全局配置，Filter工厂。设置对应的过滤条件和跳转条件，有自定义的过滤器，
     * 有shiro认证成功后，失败后，退出后等跳转的页面，有静态页面等内容的权限范围。
     */
    @Bean(name="shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //被拦截返回登录页面，如果被拦截了，跳转的地址，假如用户没有登录，先跳转登录页面！
        bean.setLoginUrl("/");  //  -----> loginPage
        //登录成功之后跳转页面
        bean.setSuccessUrl("/home_three");

        //授权拦截返回页面 如果没有权限，访问地址
        bean.setUnauthorizedUrl("/page_nopermission");

        //添加shiro内置过滤器
        Map<String, String> fMap = new HashMap<String, String>();
        //fMap.put("/admin_logout/**", "logout");//在这儿配置登出地址，不需要专门去写控制器。

        /*
         * 认证顺序是从上往下执行。
         */
        //静态资源不拦截
        fMap.put("/css/**", "anon"); //不需要验证  anon:表示可以匿名使用。
        fMap.put("/images/**", "anon"); //不需要验证  anon:表示可以匿名使用。
        fMap.put("/js/**", "anon"); //不需要验证  anon:表示可以匿名使用。
        //获取验证码不拦截
        fMap.put("/code/**", "anon");    //不需要验证  anon:表示可以匿名使用。
        fMap.put("/admin_login", "anon");    //不需要验证  anon:表示可以匿名使用
        //拦截未授权
        fMap.put("/product_page/**", "perms[产品模块:查询]");
        fMap.put("/product_add/**", "perms[产品模块:新增]");
        //fMap.put("/product_details/**", "perms[产品模块:详情]");
        //fMap.put("/product_changeStatus/**", "perms[产品模块:停售]");
        fMap.put("/user_page/**", "perms[用户模块:详情]");
        fMap.put("/home_three/**", "perms[统计模块:查询]");
        fMap.put("/myAcountPage/**", "perms[账户模块:查询]");
        fMap.put("/admin_update/**", "perms[账户模块:修改]");
        // 除此之外，必须登录
        fMap.put("/**", "authc"); // authc:表示需要认证(登录)才能使用，没有参数
        bean.setFilterChainDefinitionMap(fMap);
        return bean;
    }
    //--------------开启Shiro注解授权---------------
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return sourceAdvisor;
    }


    //-----------标签授权---------
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }


    /**
         * Shiro缓存管理器
         * @return
         */
    @Bean
    public CacheManager cacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    }
