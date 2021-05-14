package com.sist.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 재사용 => 자동호출 
/*
 *   공통기반 (자동 호출)
 *   핵심기반 (스프링 => 핵심 내용만 코딩)
 *   
 *   자동 호출 
 *   1) 어떤 메소드 적용 : PointCut 
 *   2) 호출가 위치 어디인지 : JoinPoint
 *      = Before
 *      public void display()
 *      {
 *          @Before : getConnection()
 *          try
 *          {
 *               @Around => setAutoCommit(false)
 *                 SQL
 *                 SQL
 *               @Around => commit()
 *                => 트랜잭션 , 시간(수행) , 로그파일 
 *          }catch(Exception e)
 *          {
 *             @After-Throwing
 *          }
 *          finally
 *          {
 *              @After : disConnection()
 *          }
 *          
 *          정상 : return @After-Returning
 *      }
 *      = After
 *      = After-Returning
 *      = After-Throwing
 *      = Around
 *      
 *      ===========================> PointCut+JoinPoint=Advice (Advice여러개 => Aspect)
 */
import java.util.*;

import javax.servlet.http.HttpSession;

import java.text.*;
@Component  // 메모리 할당
@Aspect
public class MyAspect {
   @Around("execution(* com.sist.web.*Controller.*(..))")
   public Object around(ProceedingJoinPoint jp) throws Throwable
   {
	   Object obj=null;
	   long start=System.currentTimeMillis();
	   obj=jp.proceed(); // 호출된 메소드를 가지고 온다 
	   long end=System.currentTimeMillis();
	   String today=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	   System.out.println("호출 시간:"+today);
	   System.out.println("사용자 요청 메소드:"+jp.getSignature().getName());
	   System.out.println("수행시간:"+(end-start));
	   System.out.println("===============================");
	   return obj;
   }
   @Before("execution(* com.sist.web.LoginController.member_login_ok(..))")
   public void before(JoinPoint joinPoint)
   {
	   HttpSession session=null;
	   Object[] data=joinPoint.getArgs();
	   session=(HttpSession)data[2];
	   String id=(String)data[0];
	   String pwd=(String)data[1];
	   session.setAttribute("id", id);
	   session.setAttribute("pwd", pwd);
   }
}















