package com.cultuzz.cultconnect.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author MaheshKumar Routh.
 * @version 1.0
 * Created on 2018-12-17 12:39
 **/

@Component
public class ResponseMonitoringFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ResponseMonitoringFilter.class);

    @Override
    public String filterType() {
        return "post";
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
        final HttpServletResponse response = context.getResponse();
        final int status = response.getStatus();
        logger.info("Response Status : {}, content type {} ", status, response.getContentType());

        return null;
    }
}
