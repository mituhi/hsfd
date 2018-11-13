package com.qz.zframe.run.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.MaintainLog;
import com.qz.zframe.run.service.MaintainLogService;

@Aspect
@Component
public class LogAspect {
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private MaintainLogService maintainLogService;
	
	private MaintainLog maintainLog;
	
    @Pointcut("execution(* com.qz.zframe.run.controller.*.*edit*(..)) || execution(* com.qz.zframe.run.controller.*.*save*(..)) || execution(* com.qz.zframe.run.controller.*.*remove*(..))")
    public void webPointCut(){}
 
    @Before("webPointCut()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
    	
    	maintainLog = new MaintainLog();
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        //用户id
        //String userId = currentUserService.getId();
        maintainLog.setUserId("chen");
        //用户名
        //maintainLog.setUsername(currentUserService.getUsername());
        maintainLog.setUsername("chq1");
        //访问的url
        maintainLog.setUrl(request.getRequestURL().toString());
        //执行的方法
        maintainLog.setMethod(request.getMethod());
        //时间
        maintainLog.setTime(new Date());
        
    }
    
    @AfterReturning(returning = "ret", pointcut = "webPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	ResultEntity resultEntity = (ResultEntity)ret;
    	if(resultEntity.getMsg()==""){
    		resultEntity.setMsg("操作未执行");
    	}
    	maintainLog.setResult(resultEntity.getMsg());
    	//执行插入
    	maintainLogService.saveMaintainLog(maintainLog);
    }

}
