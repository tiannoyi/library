package com.qf.aspect;

import com.qf.entity.Admin;
import com.qf.entity.Logs;
import com.qf.service.ILogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-25 19:08
 **/
@Aspect
@Component
public class LogAspect {

    @Autowired
    ILogService logService;

    @Pointcut("@annotation(com.qf.aspect.OperationLogger)")
    public void controllerAspect(){
        System.out.println("切入点》》》》");
    }

    @AfterReturning("controllerAspect()")
    public void doAfterReturn(JoinPoint joinPoint){
        System.out.println("==========后置通知=========");
        handleLog(joinPoint);
    }



    private void handleLog(JoinPoint joinPoint){
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Admin user = (Admin) request.getSession().getAttribute("admin");
            //获取横切的方法名
            String methodName = joinPoint.getSignature().getName();
//            String methodName = signature.substring(
//                    signature.lastIndexOf(".")+1,signature.indexOf("("));
            //获取拦截的class
            String classType = joinPoint.getTarget().getClass().getName();
            //加载这个类
            Class<?> clazz = Class.forName(classType);
            //获取这个类上的方法名
            Method[] methods= clazz.getDeclaredMethods();

            System.out.println("methodName:"+methodName);
            /**
             * 循环判断，对所有方法进行循环遍历
             */
            for (Method method:methods){
                // 如果这个方法上面的注解是否含有自定义的注解
                // 并且方法名等于切点访问的方法名
                if (method.isAnnotationPresent(OperationLogger.class)
                        &&method.getName().equals(methodName)){
                    //获取method的注解
                    OperationLogger operationLogger = method.getAnnotation(OperationLogger.class);
                    //也可以用这种方式获取
                    /*Annotation[] annotations = method.getAnnotations();
                    for (Annotation annotation:annotations){
                        if (annotation instanceof OperationLogger){
                            OperationLogger operationLogger = (OperationLogger) annotation;
                        }
                    }*/
                    Logs logs = new Logs();
                    if (user!=null){
                        logs.setAdminId(user.getAdminId());
                        //sysLog.setOptip(RequestIpUtil.getRemoteHost(request));
                    }else{
                        logs.setAdminId(0);
                       // sysLog.setOptip(RequestIpUtil.getRemoteHost(request));
                    }
                    logs.setTime(new Date());
                    logs.setOpeDetail(operationLogger.option());
                    logs.setOpeAction(operationLogger.modelName());
                    logs.setOpeEntity(operationLogger.opEntity());
                    logService.insertLog(logs);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
