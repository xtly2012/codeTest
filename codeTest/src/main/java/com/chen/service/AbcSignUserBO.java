package com.chen.service;


public class AbcSignUserBO extends SignUserBO
{
    
    /**
     * 请求序列号
     */
    private String requestId;
    
    /**
     * 用户编号
     */
    private String userId;
    
    /**
     * 收款商户编号
     */
    private String merId;
    
    /**
     * 客户姓名
     */
    private String custName;
    
    /**
     * 客户号
     */
    private String custCode;
    
    /**
     * 订单编号
     */
    private String payNo;
    
    /**
     * 支付银行编号
     */
//    private String bankCode;
    
    /**
     * 网关银行编号
     */
    private String gateBankCode;
    
    /**
     * 加密信息
     */
    private String custSignInfo;

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getMerId()
    {
        return merId;
    }

    public void setMerId(String merId)
    {
        this.merId = merId;
    }

    public String getCustName()
    {
        return custName;
    }

    public void setCustName(String custName)
    {
        this.custName = custName;
    }

    public String getCustCode()
    {
        return custCode;
    }

    public void setCustCode(String custCode)
    {
        this.custCode = custCode;
    }

    public String getPayNo()
    {
        return payNo;
    }

    public void setPayNo(String payNo)
    {
        this.payNo = payNo;
    }

    public String getGateBankCode()
    {
        return gateBankCode;
    }

    public void setGateBankCode(String gateBankCode)
    {
        this.gateBankCode = gateBankCode;
    }

//    public String getBankCode()
//    {
//        return bankCode;
//    }
//
//    public void setBankCode(String bankCode)
//    {
//        this.bankCode = bankCode;
//    }

    public String getCustSignInfo()
    {
        return custSignInfo;
    }

    public void setCustSignInfo(String custSignInfo)
    {
        this.custSignInfo = custSignInfo;
    }
       
}
