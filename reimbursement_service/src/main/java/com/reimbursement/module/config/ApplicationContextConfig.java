package com.reimbursement.module.config;


import com.reimbursement.module.util.executor.RefundListFunc;
import com.reimbursement.module.util.globalBuffer.globalBuffer;
import com.reimbursement.module.util.httpInvoke.Interface.RpcMainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;


@Configuration
public class ApplicationContextConfig {

    @Bean
    public globalBuffer getglobalBuffer(){
        return new globalBuffer();
    }

    // port = 9010
    @Bean("/reimbursement/rpcService")
    public HttpInvokerServiceExporter serverService(RpcMainController testService) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(testService);
        httpInvokerServiceExporter.setServiceInterface(RpcMainController.class);
        return httpInvokerServiceExporter;
    }
    @Bean("getRefundListFunc")
    public RefundListFunc refundListFunc(){
        return new RefundListFunc();
    }
}
