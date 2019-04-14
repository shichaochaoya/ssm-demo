package spring_demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;


/**
 * 注解切面配置
 * */
//@Component//组件，可被spring扫描到
//@Aspect//声明切面
public class UserAspect {
    @Pointcut(value = "execution(* spring_demo.service.*.*(..)")//声明切点 value内正则表达式 service包内任意类的所有方法
    public void pointCut() {}



    /**
     * advice 要干什么事情，什么时候干
     * */

    @Before(value = "pointCut()")//前置通知
    public void doDefore(JoinPoint joinPoint) {//joinPoint：连接点 程序执行的点 指程序的方法
        String name = joinPoint.getSignature().getName();//拿到名称
        Object[] args = joinPoint.getArgs();//拿到参数
        System.out.println(name + args.toString());

    }


    @After(value = "pointCut()")//后置通知
    public void doAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();//拿到名称
        System.out.println(name);
    }


    @AfterReturning(value = "pointCut()",returning = "result")//环绕通知
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println(result);//拦截到返回值
    }
    @AfterThrowing//抛出异常通知
    public void afterThrowing(){
    }


   /* @Around(value = "pointCut()")//控制方法执行 环绕通知
    public void around(ProceedingJoinPoint proceedingJoinPoint){//proceedingJoinPoint：推进连接点
        try {
            proceedingJoinPoint.proceed();//必须执行，不执行会卡死
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }*/
}
