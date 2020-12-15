package com.micro.config;


import com.micro.shiro.MyShiroCasRealm;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(CasConfig.class)
public class ShiroCasConfiguration {
    //cas和shiro整合过滤器名字
    private static final String CAS_FILTER = "casFilter";


    /**
     * 02-整合MyShiroCasRealm
     * @param casConfig
     * @return
     */
    @Bean(name = "myShiroCasRealm")
    public MyShiroCasRealm myShiroRealm(CasConfig casConfig){
        MyShiroCasRealm realm = new MyShiroCasRealm();
        realm.setCasServerUrlPrefix(casConfig.getCasServerUrlPrefix());
        realm.setCasService(casConfig.getCasService());
        return realm;
    }
    /**
     * 03-注册shiroFilter过滤器，让Shiro拦截Cas控制器中的请求
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        // 该值缺省为false，表示生命周期有SpringApplicationContext管理，设置为true则表示由ServletContainer管理
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        //默认拦截所有请求
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }
    /**
     * Shiro的生命周期
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    /**
     * Shiro安全管理器
     * @param realm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(MyShiroCasRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        // 指定SubjectFactory
        securityManager.setSubjectFactory(new CasSubjectFactory());
        return securityManager;
    }
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager, CasConfig casConfig, CasFilter casFilter){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl(casConfig.getLocalServerLoginUrl());
        //登录成功之后，跳转的地址控制器地址
        //factoryBean.setSuccessUrl("/users");
        //收钱失败跳转的地址，没有权限提示路径
        //factoryBean.setUnauthorizedUrl("/403");
        // 添加casFilter到shiroFilter中
        Map<String, Filter> filterMap = new HashMap<String, Filter>(1);
        filterMap.put(CAS_FILTER, casFilter);
        factoryBean.setFilters(filterMap);
        loadShiroFilterChain(factoryBean, casConfig);
        return factoryBean;
    }
    /**
     * 加载ShiroFilter权限控制规则 重点，哪些拦截，哪些放行
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean factoryBean, CasConfig casConfig) {
        /**下面这些规则配置最好配置到配置文件中*/
        Map<String, String> filterChainMap = new LinkedHashMap<String, String>();
        filterChainMap.put(casConfig.getCasFilterUrlPattern(), CAS_FILTER);//shiro集成cas后，首先添加该规则


        //匿名访问
        filterChainMap.put("/index", "anon");
        filterChainMap.put("/", "anon");
        filterChainMap.put("/page/register", "anon");

        filterChainMap.put("/product/**", "anon");

        // 所有的都拦截
        filterChainMap.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(filterChainMap);
    }
    /**
     * CAS过滤器
     */
    @Bean
    public CasFilter casFilter(CasConfig casConfig){
        CasFilter casFilter = new CasFilter();
        casFilter.setName(CAS_FILTER);
        casFilter.setEnabled(true);
        casFilter.setFailureUrl(casConfig.getLocalServerLoginUrl());
        return casFilter;
    }
}
