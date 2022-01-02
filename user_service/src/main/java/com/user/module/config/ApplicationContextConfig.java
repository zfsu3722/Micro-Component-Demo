package com.user.module.config;

import com.user.module.util.globalBuffer.globalBuffer;
import com.user.module.util.httpInvoke.Interface.AcceptMassage;
import com.user.module.util.httpInvoke.Interface.RpcMainController;
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

    @Bean("/user_service/rpcService")
    public HttpInvokerServiceExporter testService(RpcMainController testService) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(testService);
        httpInvokerServiceExporter.setServiceInterface(RpcMainController.class);
        return httpInvokerServiceExporter;
    }
    @Bean("join_service")
    public HttpInvokerProxyFactoryBean join_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9013/join/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

}
