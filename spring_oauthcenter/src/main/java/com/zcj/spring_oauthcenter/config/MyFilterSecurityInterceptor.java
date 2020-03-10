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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**@author mqz77
 * @date  2020.3.10
 * security过滤器
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
        if ("anonymousUser".equals(name)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String requestURI = httpServletRequest.getRequestURI();
            TbPermissionExample tbPermissionExample = new TbPermissionExample();
            tbPermissionExample.or().andUrlIsNotNull();
            List<TbPermission> tbPermissions = tbPermissionDao.selectByExample(tbPermissionExample);
            for (TbPermission tbPermission : tbPermissions) {
                boolean contains = StringUtils.equalsIgnoreCase(tbPermission.getUrl(), requestURI);
                if (contains) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect("http://www.baidu.com");
        }
    }
}
