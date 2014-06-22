package com.chen.service;

import com.ofpay.comm.exception.BaseException;


public interface PayFastGateService <T extends SignUserBO>
{
    
    /**
     * 快捷支付签约
     * @param reqMap - 签约信息
     * @param gatekey - 支付网关密钥
     * @return - 签约成功返回true，失败返回false
     * @throws BaseException - 抛出异常，调用getErrorId方法可以获取错误编码
     */
    String signUp(T signUserBo);
    
    /**
     * 快捷支付解约
     * @param reqMap - 签约信息
     * @param gatekey - 支付网关密钥
     * @param signUser - 签约用户信息
     * @return - 签约成功返回true，失败返回false
     * @throws BaseException - 抛出异常，调用getErrorId方法可以获取错误编码
     */
    boolean signOff(T signUserBo);
    
    /**
     * 快捷支付解约
     * @param reqMap - 签约信息
     * @return - 签约成功返回true，失败返回false
     * @throws BaseException - 抛出异常，调用getErrorId方法可以获取错误编码
     */
    public boolean fastPay(T signUserBo);

}
