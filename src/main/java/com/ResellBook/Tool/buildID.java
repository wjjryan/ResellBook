package com.ResellBook.Tool;

import java.util.UUID;

public class buildID {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
