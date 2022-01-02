package net.xdclass.config;



import net.xdclass.localAccept.acceptServer;
import net.xdclass.remoteExe.aboutHttpInvoker.Interface.AcceptMassage;
import net.xdclass.utils.globalBuffer;
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


    @Bean("/rpcService")
    public HttpInvokerServiceExporter rpcService(acceptServer serverService){
        HttpInvokerServiceExporter httpInvokerServiceExporter=new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(serverService);
        httpInvokerServiceExporter.setServiceInterface(acceptServer.class);
        return httpInvokerServiceExporter;

    }


    @Bean("itemList_service")
    public HttpInvokerProxyFactoryBean itemList_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://138.138.0.14:9011/item/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

    @Bean("staffMsg_service")
    public HttpInvokerProxyFactoryBean staffMsg_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://138.138.0.14:9012/staff/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

    @Bean("itemJoin_service")
    public HttpInvokerProxyFactoryBean item_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://138.138.0.14:9013/join/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }

    @Bean("refund_service")
    public HttpInvokerProxyFactoryBean refund_service() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://138.138.0.14:9010/reimbursement/rpcService");
        httpInvokerProxyFactoryBean.setServiceInterface(AcceptMassage.class);
        return httpInvokerProxyFactoryBean;
    }



}
