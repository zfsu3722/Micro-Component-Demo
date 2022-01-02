package com.join.module.config;

import com.join.module.util.globalBuffer.globalBuffer;
import com.join.module.util.httpInvoke.Interface.AcceptMassage;
import com.join.module.util.httpInvoke.Interface.RpcMainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;


@Configuration
public class ApplicationContextConfig {

    @Bean
    public globalBuffer getglobalBuffer(){
        return new globalBuffer();
    }

    // port = 9013
    @Bean("/join/rpcService")
    public HttpInvokerServiceExporter serverService(RpcMainController testService) {
        //HttpInvokerServiceExporter：HttpInvokerServiceExporter是一个Spring MVC控制器，
        // 可以接收客户端请求，并将这些请求转换成对Spring bean的方法调用。
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(testService);
        httpInvokerServiceExporter.setServiceInterface(RpcMainController.class);
        return httpInvokerServiceExporter;
    }
    @Bean("controller_service")
    public HttpInvokerProxyFactoryBean controller_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://138.138.0.41:8000/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }
    @Bean("MyController_service")
    public HttpInvokerProxyFactoryBean Mycontroller_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9000/mainController/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }
}
