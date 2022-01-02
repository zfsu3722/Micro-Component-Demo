package com.common.entities;
import java.io.Serializable;

public class OrderStruct implements Serializable {

    private static final long serialVersionUID = -8382559156221010472L;

    private String orderNo;
    private String sessionId;
    private String jobId;

    public OrderStruct(String orderNo, String sessionId, String jobId) {
        this.orderNo = orderNo;
        this.sessionId = sessionId;
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
