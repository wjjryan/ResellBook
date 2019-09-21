package com.ResellBook.ServiceImp;

import com.ResellBook.Dao.StudentDao;
import com.ResellBook.Pojo.SMSType;
import com.ResellBook.Service.SendMessageService;
import com.ResellBook.Service.StudentService;
import com.ResellBook.Tool.SendMassageUtils;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class SendMessageServiceImp implements SendMessageService {

    @Autowired
    StudentDao studentDao;
    @Override
    public int sendMessage(SMSType smsType,String tel){
        int key = 0;
        if(!tel.equals(studentDao.checkTel(tel))){
            if(smsType == SMSType.Register_Type){
                if(Objects.isNull(registerCache.getIfPresent(tel))){
                    registerCache.put(tel, SendMassageUtils.sendMseeage(tel,"5"));
                    key = 1;
                }
            }
            else {
                if(Objects.isNull(forgetPasswordCache.getIfPresent(tel))){
                    forgetPasswordCache.put(tel,SendMassageUtils.sendMseeage(tel,"5"));
                    key = 1;
                }
            }
        }
        return key;
    }

    @Override
    public String getCode(SMSType smsType,String tel){
        if(smsType == SMSType.Register_Type){
            return registerCache.getIfPresent(tel);
        }
        else {
            return forgetPasswordCache.getIfPresent(tel);
        }
    }

    //用于存放验证码的cache
    private static Cache<String, String> registerCache = CacheBuilder.newBuilder()
            .expireAfterWrite(5L, TimeUnit.MINUTES)
            .build();
    private static Cache<String, String> forgetPasswordCache = CacheBuilder.newBuilder()
            .expireAfterWrite(5L, TimeUnit.MINUTES)
            .build();
}
