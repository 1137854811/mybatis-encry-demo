package com.example.mybatisencrydemo.annotation;

import java.lang.reflect.Field;

/**
 * 定义加密接口，方便以后拓展加密方法（如AES加密算法拓展支持PBE算法，只需要注入时指定一下便可）
 * @author tianzhuang
 * @version 1.0
 * @date 2022/9/9 14:07
 */
public interface EncryptUtil {
    /**
     * 加密
     * @param declaredFields
     * @param paramObject
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T encrypt(Field[] declaredFields, T paramObject) throws Exception;

    /**
     * 解密
     * @param result
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T decrypt(T result) throws Exception;

}
