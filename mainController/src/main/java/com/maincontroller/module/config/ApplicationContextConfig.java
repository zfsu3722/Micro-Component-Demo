package com.maincontroller.module.config;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.AcceptMassage;
import com.maincontroller.module.util.aboutHttpInvoke.Interface.RpcMainController;
import com.maincontroller.module.util.globalbuffer.globalBuffer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;


@Configuration
public class ApplicationContextConfig
{

    @Bean
    public globalBuffer getglobalBuffer(){
        return new globalBuffer();
    }

    @Bean("/mainController/rpcService")
    public HttpInvokerServiceExporter testService(RpcMainController testService) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(testService);
        httpInvokerServiceExporter.setServiceInterface(RpcMainController.class);
        return httpInvokerServiceExporter;
    }

    @Bean("user_service")
    public HttpInvokerProxyFactoryBean user_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9001/user_service/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }
    @Bean("shoppingCart_service")
    public HttpInvokerProxyFactoryBean shoppingCart_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9014/shoppingCart/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }
    @Bean("reimbursement_service")
    public HttpInvokerProxyFactoryBean reimbursement_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9010/reimbursement/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

    @Bean("join_service")
    public HttpInvokerProxyFactoryBean join_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:9013/join/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

    @Bean("login_service")
    public HttpInvokerProxyFactoryBean login_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://138.138.0.41:9017/shoppingCart/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

}
