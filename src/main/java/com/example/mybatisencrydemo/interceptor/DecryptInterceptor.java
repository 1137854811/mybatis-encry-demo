package com.example.mybatisencrydemo.interceptor;

import cn.hutool.core.annotation.AnnotationUtil;
import com.example.mybatisencrydemo.aes.AESUtils;
import com.example.mybatisencrydemo.annotation.SensitiveData;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.List;
import java.util.Objects;

/**
 * @author tianzhuang
 * @version 1.0
 * @date 2022/9/9 14:55
 */
@Slf4j
@Component
@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = Statement.class)})
public class DecryptInterceptor implements Interceptor {

    @Autowired
    private AESUtils aesUtil;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取结果
        Object resultObj = invocation.proceed();
        log.info("=====resultObj==={}", resultObj);
        if (Objects.isNull(resultObj)) {
            return null;
        }
        // 判断是否是list
        if (resultObj instanceof List) {
            for (Object resultList : (List) resultObj) {
                aesUtil.decrypt(resultList);
            }
        } else {
            Class<?> aClass = resultObj.getClass();
            SensitiveData annotation = AnnotationUtil.getAnnotation(aClass, SensitiveData.class);
            if (Objects.nonNull(annotation)) {
                aesUtil.decrypt(resultObj);
            }
        }
        return resultObj;
    }
}
