package com.lzg.test.ws.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
/**
 * 
 * @author lzg
 * @date 2018年5月27日 上午10:37:44
 *
 */
@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

	/**
	 * 注册WebService servlet
	 * @Title: messageDispatcherServlet
	 * @Description: TODO
	 * @param @param applicationContext
	 * @param @return
	 * @return ServletRegistrationBean
	 * @throws
	 */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

       //配置对外服务根路径
        return new ServletRegistrationBean(servlet, "/soap/*");
    }
    
//    @Bean(name = "testWebService")
//	public DefaultWsdl11Definition defaultWsdl11Definition(@Qualifier("serviceXsdSchema") XsdSchema schema) {
//		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//		wsdl11Definition.setPortTypeName("ITestWebService");
//		wsdl11Definition.setServiceName("testWebService");
//		wsdl11Definition.setLocationUri("/soap");
//		wsdl11Definition.setTargetNamespace("http://www.lzg.test.com");
//		wsdl11Definition.setSchema(schema);
//		return wsdl11Definition;
//	}
//
//	@Bean(name = "serviceXsdSchema")
//	public XsdSchema countriesSchema() {
//		return new SimpleXsdSchema(new ClassPathResource("service.xsd"));
//	}

    
    @Bean(name = "testWebService")
    public SimpleWsdl11Definition simpleWsdl11Definition() {
    	SimpleWsdl11Definition definition = new SimpleWsdl11Definition();
    	
    	Resource wsdlResource = new ClassPathResource("wsdl.xml");
		definition.setWsdl(wsdlResource );
       
        return definition;
    }

}