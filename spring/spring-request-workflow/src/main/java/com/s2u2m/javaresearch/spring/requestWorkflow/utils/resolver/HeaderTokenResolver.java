package com.s2u2m.javaresearch.spring.requestWorkflow.utils.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * class HeaderTokenResolver
 *
 * @author xiayy860612
 * @date 2018/5/14
 */
public class HeaderTokenResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return HeaderToken.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
            throws Exception {
        String value = webRequest.getHeader("token");
        if (value == null) {
            return null;
        }
        return new HeaderToken().setToken(value);
    }
}
