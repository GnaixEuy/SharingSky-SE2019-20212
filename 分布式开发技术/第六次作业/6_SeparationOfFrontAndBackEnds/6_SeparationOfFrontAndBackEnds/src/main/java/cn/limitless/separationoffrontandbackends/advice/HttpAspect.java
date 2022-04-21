package cn.limitless.separationoffrontandbackends.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <img src='https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg'/>
 * <p>
 * 项目： distributed_technology-20212
 *
 * @author GnaixEuy
 * @date 2022/4/20
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution(public * cn.limitless.controller.*.*(..))")
    public void log() {
    }

    @Before(value = "log()")
    public void logBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        //url
        HttpAspect.LOGGER.info("url={}", request.getRequestURI());

        //method
        HttpAspect.LOGGER.info("method={}", request.getMethod());
        //IP:Port
        HttpAspect.LOGGER.info("IP:PORT={}", request.getRemoteAddr());
        //调用的服务
        HttpAspect.LOGGER.info("Class_Method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //传递的参数
        Object[] args = joinPoint.getArgs();
        StringBuilder argsStr = new StringBuilder();
        for (Object arg : args) {
            argsStr.append(arg.toString());
        }
        HttpAspect.LOGGER.info("args={}", argsStr);
    }


    @AfterReturning(pointcut = "log()", returning = "ret")
    public void logAfterRet(Object ret) {
        HttpAspect.LOGGER.info("response={}", ret.toString());
    }
}
