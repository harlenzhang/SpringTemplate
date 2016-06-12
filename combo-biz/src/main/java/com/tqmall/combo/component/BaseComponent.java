package com.tqmall.combo.component;

import lombok.extern.slf4j.Slf4j;

/**
 * 不带出参的doBusiness，一般用于前期的参数处理
 *
 * Created by YangFalcom on 15/9/8.
 */
@Slf4j
public abstract class BaseComponent<Request> {

//    @Setter
//    protected LinkedHashSet<BusinessCheck<Request>> businessChecks;
//
//    @Setter
//    protected LinkedHashSet<CommonCheck> commonChecks;

    public void execute(Request request) {
        try {
//            this.check(request);
            doBusiness(request);
        } catch (RuntimeException e) {
            log.info("");
            throw e;
        }
    }

    /**
     * 不带返回值的doBusiness
     */
    protected abstract void doBusiness(Request request);

//    protected void check(Request request) {
//        this.commonCheck();
//        this.businessCheck(request);
//    }

//    private void commonCheck() {
//        if (CollectionUtils.isEmpty(commonChecks)) return;
//
//        for (CommonCheck commonCheck : commonChecks) {
//            commonCheck.doCheck();
//        }
//    }
//
//    private void businessCheck(Request request) {
//        if (CollectionUtils.isEmpty(businessChecks)) return;
//
//        for (BusinessCheck<Request> businessCheck : businessChecks) {
//            businessCheck.doCheck(request);
//        }
//    }
}
