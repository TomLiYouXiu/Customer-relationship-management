package xyz.liyouxiu.crm.commons.utils;

import java.util.UUID;

/**
 * @author liyouxiu
 * @date 2022/10/23 10:18
 */
public class UUIDUtils {
    //用来获取UUID字符串
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
