package com.cultuzz.cultconnect.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MaheshKumar Routh.
 * @version 1.0
 * Created on 2018-12-17 12:36
 **/

@Component
public class RequestMonitoringFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(RequestMonitoringFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        final RequestContext context = RequestContext.getCurrentContext();
        final HttpServletRequest request = context.getRequest();
        logger.info("Accessing Context Path {}, ServletPath {}", request.getContextPath(), request.getServletPath());
        return null;
    }
    
}

