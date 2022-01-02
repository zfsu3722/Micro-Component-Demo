package com.item.module.config;


import com.item.module.util.globalBuffer.globalBuffer;
import com.item.module.util.httpInvoke.Interface.AcceptMassage;
import com.item.module.util.httpInvoke.Interface.RpcMainController;
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

    //port = 9011
    @Bean("/item/rpcService")
    public HttpInvokerServiceExporter serverService(RpcMainController testService) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(testService);
        httpInvokerServiceExporter.setServiceInterface(RpcMainController.class);
        return httpInvokerServiceExporter;
    }

    @Bean("staff_service")
    public HttpInvokerProxyFactoryBean order_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9012/staff/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

    @Bean("join_service")
    public HttpInvokerProxyFactoryBean controller_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9013/join/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }
}
