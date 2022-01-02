package com.employee.module.config;

import com.employee.module.util.globalBuffer.globalBuffer;
import com.employee.module.util.httpInvoke.Interface.AcceptMassage;
import com.employee.module.util.httpInvoke.Interface.RpcMainController;
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

    //port = 9012
    @Bean("/staff/rpcService")
    public HttpInvokerServiceExporter serverService(RpcMainController testService) {
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
