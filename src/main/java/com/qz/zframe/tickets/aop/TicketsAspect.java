package com.qz.zframe.tickets.aop;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.run.entity.MaintainLog;
import com.qz.zframe.run.service.MaintainLogService;
import com.qz.zframe.tickets.entity.TicketsOperateRecord;
import com.qz.zframe.tickets.mapper.TicketsOperateRecordMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.security.krb5.internal.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class TicketsAspect {

    private static Logger logger = LoggerFactory.getLogger(TicketsAspect.class);
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private TicketsOperateRecordMapper ticketsOperateRecordMapper;
	
	private TicketsOperateRecord ticketsOperateRecord = new TicketsOperateRecord();
	
    @Pointcut("execution(* com.qz.zframe.tickets.controller.*.*add*(..)) " +
            "|| execution(* com.qz.zframe.tickets.controller.*.*update*(..)) " +
            "|| execution(* com.qz.zframe.tickets.controller.*.*submit*(..)) " +
            "|| execution(* com.qz.zframe.tickets.controller.*.*delete*(..))")
    public void webPointCut(){}
 
    @Before("webPointCut()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
    	
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //设置id
        ticketsOperateRecord.setId(UUIdUtil.getUUID()+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        //用户id
        ticketsOperateRecord.setUserId(currentUserService.getId());
        //访问的url
        ticketsOperateRecord.setUrl(request.getRequestURL().toString());
        //执行的方法
        ticketsOperateRecord.setMethod(request.getMethod());
        //时间
        ticketsOperateRecord.setOperateTime(new Date());
        
    }
    
    @AfterReturning(returning = "ret", pointcut = "webPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	ResultEntity resultEntity = (ResultEntity)ret;
    	if(resultEntity.getMsg()==""){
    		resultEntity.setMsg("操作未执行");
    	}
        ticketsOperateRecord.setResult(resultEntity.getMsg());

        logger.info("===== 添加两票操作记录 =====");
    	//执行插入
        ticketsOperateRecordMapper.insert(ticketsOperateRecord);
    }

}
