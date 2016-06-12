package com.tqmall.combo.controller;


//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;

import com.tqmall.core.common.entity.BaseResult;
import com.tqmall.core.common.exception.BusinessCheckFailException;
import com.tqmall.core.common.exception.BusinessProcessFailException;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.objenesis.ObjenesisStd;

//import java.lang.reflect.Method;


@Slf4j
public class ResultServiceWrapper implements MethodInterceptor {

    private ObjenesisStd generator = new ObjenesisStd();

    @Override
    public BaseResult invoke(final MethodInvocation invocation) throws Throwable {
//        Object[] args = invocation.getArguments();
//        Method method = invocation.getMethod();
//        String methodName = method.getDeclaringClass().getName() + "." + method.getName();

        BaseResult result;
        try {
            result = (BaseResult) invocation.proceed();
//            log.info("[method=" + methodName + "] params={}, result={}", JSONArray.toJSONString(args), JSON.toJSONString(result));
            return result;
        } catch (BusinessProcessFailException e) {
            result = getBaseResult(invocation);

            result.setSuccess(false);
            result.setMessage(e.getMessage());
            result.setCode(e.getErrorCode());
            handleBusinessException(e);
        } catch (BusinessCheckFailException e) {
            result = getBaseResult(invocation);

            result.setSuccess(false);
            result.setMessage(e.getMessage());
            result.setCode(e.getErrorCode());
            handleBusinessException(e);
        } catch (Exception e) {
            result = getBaseResult(invocation);

            setSystemError(result);
            handleThrowable(e);
        }
        return result;
    }

    private BaseResult getBaseResult(MethodInvocation methodInvocation) {
        Class<?> returnType = methodInvocation.getMethod().getReturnType();
        return (BaseResult) generator.newInstance(returnType);
    }

    private void setSystemError(BaseResult result) {
        log.error("系统异常:code={}, message={}", result.getCode(), result.getMessage());
        result.setSuccess(false);
        result.setCode("1111");
        result.setMessage("系统繁忙，请稍后重试");
    }

    private void handleThrowable(Throwable e) {
        log.error("系统出错:", e);
    }

    private void handleBusinessException(RuntimeException e) {
        log.error("业务出错:", e);
    }

}
