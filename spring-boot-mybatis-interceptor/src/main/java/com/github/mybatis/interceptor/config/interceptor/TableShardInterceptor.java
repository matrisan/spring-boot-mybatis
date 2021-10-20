package com.github.mybatis.interceptor.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.Properties;

/**
 * -@Intercepts：标识该类是一个拦截器；
 * -@Signature：指明自定义拦截器需要拦截哪一个类型，哪一个方法；
 * -------type：对应四种类型中的一种；
 * -------method：对应接口中的哪类方法（因为可能存在重载方法）；
 * -------args：对应哪一个方法；
 * <p>
 * 拦截的类	            拦截的方法
 * Executor	            update, query, flushStatements, commit, rollback,getTransaction, close, isClosed
 * ParameterHandler     getParameterObject, setParameters
 * StatementHandler     prepare, parameterize, batch, update, query
 * ResultSetHandler     handleResultSets, handleOutputParameters
 * <p>
 * create in 2021/7/7 9:47 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})
})
//@Component
public class TableShardInterceptor implements Interceptor {

    /**
     * 代理对象每次调用的方法，就是要进行拦截的时候要执行的方法。在这个方法里面做我们自定义的逻辑处理
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 被代理对象
        Object target = invocation.getTarget();
        // 代理方法
        Method method = invocation.getMethod();
        // 方法参数
        Object[] args = invocation.getArgs();
        // do something ...... 方法拦截前执行代码块
        Object result = invocation.proceed();
        // do something .......方法拦截后执行代码块
        return result;
    }

    /**
     * plugin方法是拦截器用于封装目标对象的，通过该方法我们可以返回目标对象本身，也可以返回一个它的代理
     * 当返回的是代理的时候我们可以对其中的方法进行拦截来调用intercept方法 -- Plugin.wrap(target, this)
     * 当返回的是当前对象的时候 就不会调用intercept方法，相当于当前拦截器无效
     */
    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    /**
     * 用于在Mybatis配置文件中指定一些属性的，注册当前拦截器的时候可以设置一些属性
     */
    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
