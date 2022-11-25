package com.example.mybatisencrydemo.aes;

import cn.hutool.crypto.SecureUtil;
import com.example.mybatisencrydemo.annotation.EncryptUtil;
import com.example.mybatisencrydemo.annotation.SensitiveField;
import com.example.mybatisencrydemo.util.AesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author tianzhuang
 * @version 1.0
 * @date 2022/9/9 14:09
 */
@Component
@Slf4j
public class AESUtils implements EncryptUtil {

    /**
     * 加密
     * @param declaredFields
     * @param paramObject
     * @param <T>
     * @return
     */
    @Override
    public <T> T encrypt(Field[] declaredFields, T paramObject) throws Exception {
        log.info("======={}------{}", declaredFields, paramObject);
        for (Field field : declaredFields) {

            //取出所有被EncryptDecryptField注解的字段
            SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);

            if (!Objects.isNull(sensitiveField)) {
                field.setAccessible(true);
                Object o = field.get(paramObject);
                // 暂时实现对String加密
                if (o instanceof String) {
                    String val = (String) o;
                    field.set(paramObject, AesUtil.Encrypt(val));
                }
            }
        }
        log.info("加密后===={}", paramObject);
        return paramObject;
    }

    /**
     * 解密
     *
     * @param result
     * @return
     * @throws Exception
     */
    @Override
    public <T> T decrypt(T result) throws Exception {
        //取出resultType的类
        Class<?> resultClass = result.getClass();
        Field[] declaredFields = resultClass.getDeclaredFields();
        for (Field field : declaredFields) {
            SensitiveField annotation = field.getAnnotation(SensitiveField.class);
            if (Objects.nonNull(annotation)) {
                field.setAccessible(true);
                // 获取属性
                Object o = field.get(result);
                log.info("属性是：{}", o);
                if (o instanceof String) {
                    field.set(result, AesUtil.Decrypt((String) o));
                }
            }
        }

        return result;
    }
}