package com.nsn.demo.web.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.*;
import java.io.IOException;
import java.util.EnumSet;

@Configuration
@EnableWebMvc
@ComponentScan("com.nsn")
public class WebConfiguration  {

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilter() {
		FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<CharacterEncodingFilter>();
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		filterRegistrationBean.setFilter(filter);
		filterRegistrationBean.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return filterRegistrationBean;
	}

	@Bean
    Filter myCharsetEncodingFilter() {

		return new Filter() {
			public void init(FilterConfig filterConfig) throws ServletException {
			}

			public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                                 FilterChain filterChain) throws IOException, ServletException {

				servletRequest.setCharacterEncoding("UTF-8");
				servletResponse.setContentType("text/html;charset=UTF-8");

				filterChain.doFilter(servletRequest, servletResponse);
			}

			public void destroy() {
			}

		};
	}

	/**
	 * 对multipart类型 (文件)的默认处理设置 由commons-upload实现 需要引入
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}

}

