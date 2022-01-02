package com.cart.module.config;


import com.cart.module.util.globalBuffer.globalBuffer;
import com.cart.module.util.httpInvoke.Interface.AcceptMassage;
import com.cart.module.util.httpInvoke.Interface.RpcMainController;
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


    @Bean("/shoppingCart/rpcService")
    public HttpInvokerServiceExporter serverService(RpcMainController testService) {

        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(testService);
        httpInvokerServiceExporter.setServiceInterface(RpcMainController.class);
        return httpInvokerServiceExporter;
    }

}
