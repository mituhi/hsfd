package com.qz.zframe.maintain.aop;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.MaintainOperateRecord;
import com.qz.zframe.maintain.mapper.MaintainOperateRecordMapper;
import com.qz.zframe.tickets.entity.TicketsOperateRecord;
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

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class MaintainAspect {

    private static Logger logger = LoggerFactory.getLogger(MaintainAspect.class);
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private MaintainOperateRecordMapper maintainOperateRecordMapper;
	
	private MaintainOperateRecord maintainOperateRecord = new MaintainOperateRecord();
	
    @Pointcut("execution(* com.qz.zframe.maintain.controller.*.*add*(..)) " +
            "|| execution(* com.qz.zframe.maintain.controller.*.*update*(..)) " +
            "|| execution(* com.qz.zframe.maintain.controller.*.*submit*(..)) " +
            "|| execution(* com.qz.zframe.maintain.controller.*.*delete*(..))")
    public void webPointCut(){}
 
    @Before("webPointCut()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
    	
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //设置id
        maintainOperateRecord.setId(UUIdUtil.getUUID()+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        //用户id
        maintainOperateRecord.setUserId(currentUserService.getId());
        //访问的url
        maintainOperateRecord.setUrl(request.getRequestURL().toString());
        //执行的方法
        maintainOperateRecord.setMethod(request.getMethod());
        //时间
        maintainOperateRecord.setOperateTime(new Date());
        
    }
    
    @AfterReturning(returning = "ret", pointcut = "webPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	ResultEntity resultEntity = (ResultEntity)ret;
    	if(resultEntity.getMsg()==""){
    		resultEntity.setMsg("操作未执行");
    	}
        maintainOperateRecord.setResult(resultEntity.getMsg());

        logger.info("===== 添加维护操作记录 =====");
    	//执行插入
        maintainOperateRecordMapper.insert(maintainOperateRecord);
    }

}
