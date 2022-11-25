package com.example.mybatisencrydemo.interceptor;

import cn.hutool.core.annotation.AnnotationUtil;
import com.example.mybatisencrydemo.aes.AESUtils;
import com.example.mybatisencrydemo.annotation.SensitiveData;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Properties;

/**
 *
 * 加密拦截
 * @author tianzhuang
 * @version 1.0
 * @date 2022/9/9 14:23
 */
@Slf4j
@Component
@Intercepts({@Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class)})
public class EncryptInterceptor implements Interceptor {

    @Autowired
    private AESUtils aesEncrypt;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //@Signature 指定了 type= parameterHandler 后，这里的 invocation.getTarget() 便是parameterHandler
        //若指定ResultSetHandler ，这里则能强转为ResultSetHandler
        ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
        log.info("============parameterHandler ==={}", parameterHandler);

        // 获取参数对像，即 mapper 中 paramsType 的实例
        Field parameterField = parameterHandler.getClass().getDeclaredField("parameterObject");
        log.info("============parameterField ==={}", parameterField);

        parameterField.setAccessible(true);
        // 取出实例
        Object parameterObject = parameterField.get(parameterHandler);
        log.info("============parameterObject ==={}", parameterObject);

        if (!Objects.isNull(parameterObject)) {
            Class<?> parameterObjectClass = parameterObject.getClass();
            log.info("============parameterObjectClass ==={}", parameterObjectClass);

            //校验该实例的类是否被@SensitiveData所注解
            SensitiveData sensitiveData = AnnotationUtil.getAnnotation(parameterObjectClass, SensitiveData.class);
            log.info("============sensitiveData ==={}", sensitiveData);

            if (Objects.nonNull(sensitiveData)) {
                Field[] declaredFields = parameterObjectClass.getDeclaredFields();
                aesEncrypt.encrypt(declaredFields, parameterObject);
            }
        }
        log.info("==========proceed==-{}---", invocation.proceed());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
