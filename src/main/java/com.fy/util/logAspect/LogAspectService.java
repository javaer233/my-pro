package com.fy.util.logAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bzl on 2016-12-09 16:41:07
 * @param 
 * @return  
 * @TODO 
 */
public class LogAspectService {

    private Logger logger = LoggerFactory.getLogger(LogAspectService.class);

    public void doBefore(JoinPoint jp) {

    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        time = System.currentTimeMillis() - time;
        logger.info("{}.{} => process time: {} ms", pjp.getTarget().getClass().getName(), pjp.getSignature().getName(), time);

        return retVal;
    }

    public void doAfter(JoinPoint jp) {

    }

    public void doThrowing(JoinPoint jp, Throwable ex) {
        logger.error("method => " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception", ex);
    }
}
