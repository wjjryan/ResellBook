package com.ResellBook.Service;

import com.ResellBook.Pojo.SMSType;

public interface SendMessageService {

    int sendMessage(SMSType smsType,String tel);
    String getCode(SMSType smsType,String tel);
}
