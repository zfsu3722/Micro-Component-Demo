package com.user.entities;

import java.util.List;

public class OutputParam {

    private String destRef;
    List<OutData> outDatas;

    public OutputParam(){}

    public String getDestRef() {
        return destRef;
    }

    public void setDestRef(String destRef) {
        this.destRef = destRef;
    }

    public List<OutData> getOutDatas() {
        return outDatas;
    }

    public void setOutDatas(List<OutData> outDatas) {
        this.outDatas = outDatas;
    }
}
