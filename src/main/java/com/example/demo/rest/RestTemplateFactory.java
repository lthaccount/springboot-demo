package com.example.demo.rest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean{
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate(){
        return this.restTemplate;
    }

    @Autowired
    private HttpMessageConverters httpMessageConverters;

    public RestTemplateFactory(){
        System.out.println("RestTemplateFactory初始化");
    }

    @Nullable
    @Override
    public RestTemplate getObject() throws Exception {
        return this.restTemplate;
//        return new RestTemplate();
    }

    /**
     * 申明getObject()方法获取到的bean是否为单例
     * 当return true时，getObject()方法返回的bean会加入单例缓存池，即使是new出来的对象，也是单例的
     * 不重写此方法，默认为单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return RestTemplate.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        restTemplate = new RestTemplate(httpMessageConverters.getConverters());
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(httpclient);
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(10000);
        restTemplate.setRequestFactory(requestFactory);
    }
}
