package com.tqmall.combo.processor;

import com.tqmall.combo.component.BaseComponent;
import com.tqmall.combo.component.ResultComponent;
import lombok.Setter;

import java.util.LinkedHashSet;

/**
 * Created by YangFalcom on 15/9/8.
 */
public abstract class BaseProcessor<Request, Result> {

    @Setter
    protected LinkedHashSet<BaseComponent<Request>> components;

    @Setter
    protected ResultComponent<Request, Result> resultComponent;

    public Result doProcessor(Request request) {
        Result result;
        try {
            this.doBusiness(request);
            result = resultComponent.execute(request);
            this.afterProcess(result);
        } catch (RuntimeException e) {
            throw e;
        }
        return result;
    }

    protected void doBusiness(Request request) {
        for (BaseComponent<Request> component : components) {
            component.execute(request);
        }
    }

    protected abstract void afterProcess(final Result result);
}
