package com.example.airticketsorderservice.common.jwt;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class JwtUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(JwtUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String authorizeToken = webRequest.getHeader(JwtTokenHelper.AUTHORIZATION);
        if (StringUtils.isEmpty(authorizeToken)) {
            return new JwtServiceUser();
        }

        return JwtTokenHelper.parseUserByAuthorizeToken(authorizeToken);
    }
}
