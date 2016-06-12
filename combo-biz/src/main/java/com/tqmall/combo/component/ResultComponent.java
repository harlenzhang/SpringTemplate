package com.tqmall.combo.component;

import lombok.extern.slf4j.Slf4j;

/**
 * 带出参的doBusiness
 *
 * Created by YangFalcom on 15/9/15.
 */
@Slf4j
public abstract class ResultComponent<Request, Result> {

//    @Setter
//    protected LinkedHashSet<BusinessCheck<Request>> businessChecks;
//
//    @Setter
//    protected LinkedHashSet<CommonCheck> commonChecks;

    public Result execute(final Request request) {
        Result result;
        try {
//            this.check(request);
            result = doBusiness(request);
        } catch (RuntimeException e) {
            log.info("");
            throw e;
        }
        if (result == null) {
            throw new RuntimeException("");
        }
        return result;
    }

    /**
     * 根据需要取用，不带返回值的doBusiness
     */
    protected abstract Result doBusiness(final Request request);

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
