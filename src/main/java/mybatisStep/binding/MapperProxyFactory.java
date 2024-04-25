package mybatisStep.binding;

import mybatisStep.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Description 映射器代理工厂
 * @Date 2024/4/11 14:33
 * @Created by lenovo
 */
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }


    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession){
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        // 创建代理对象  通过接口找到被代理对象的类,实现所有接口的方法 通过代理对象调用方法时,会调用invoke方法
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
