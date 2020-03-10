package com.zcj.spring_oauthcenter.config;

import com.zcj.spring_oauthcenter.dao.TbPermissionDao;
import com.zcj.spring_oauthcenter.dao.TbUserDao;
import com.zcj.spring_oauthcenter.po.TbPermission;
import com.zcj.spring_oauthcenter.po.TbPermissionExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author mqz77
 * @date 2020.3.10
 * security过滤器(负责接口权限)
 */
@Configuration
public class MyFilterSecurityInterceptor extends GenericFilterBean {


    private final TbPermissionDao tbPermissionDao;

    private final TbUserDao tbUserDao;

    @Autowired
    public MyFilterSecurityInterceptor(TbPermissionDao tbPermissionDao, TbUserDao tbUserDao) {
        this.tbPermissionDao = tbPermissionDao;
        this.tbUserDao = tbUserDao;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("This is a filter before UsernamePasswordAuthenticationFilter.");
        // 继续调用 Filter 链
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
//        接口的正则表达式匹配规则
        String urlMatches = "^/oauth/\\S*|^/noOauth";
        System.out.println(requestURI);
        //查看是否登录(因为这个过滤器加在了security过滤链的最后，所以未登录用户是anonymousUser)
        if ("anonymousUser".equals(name) || requestURI.matches(urlMatches)) {
            //未登录放行login页面
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
//           已登录查看接口权限
            TbPermissionExample tbPermissionExample = new TbPermissionExample();
            tbPermissionExample.or().andUrlIsNotNull();
            List<TbPermission> tbPermissions = tbPermissionDao.selectByExample(tbPermissionExample);
            int hasOauth = 0;
            for (TbPermission tbPermission : tbPermissions) {
                boolean contains = StringUtils.equalsIgnoreCase(tbPermission.getUrl(), requestURI);
                if (contains) {
                    hasOauth = 1;
                    filterChain.doFilter(servletRequest, servletResponse);
                    break;
                }
            }
            switch (hasOauth) {
                case 0: {
                    httpServletRequest.getRequestDispatcher("/noOauth").forward(servletRequest, servletResponse);
                    break;
                }
            }
//            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//            httpServletResponse.sendRedirect("/noOauth");
        }
    }
}
