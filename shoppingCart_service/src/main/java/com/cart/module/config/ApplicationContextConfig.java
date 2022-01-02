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

    //port = 9014
    @Bean("/shoppingCart/rpcService")
    public HttpInvokerServiceExporter serverService(RpcMainController testService) {
        //HttpInvokerServiceExporter：HttpInvokerServiceExporter是一个Spring MVC控制器，
        // 可以接收客户端请求，并将这些请求转换成对Spring bean的方法调用。
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
