package mybatisStep.binding;

import cn.hutool.core.lang.ClassScanner;
import mybatisStep.session.Configuration;
import mybatisStep.session.SqlSession;

import java.util.HashMap;
import java.util.Set;

/**
 * @Description 映射器注册机
 * @Date 2024/4/18 13:30
 * @Created by lenovo
 */
public class MapperRegistry {
    private Configuration config;


    public MapperRegistry(Configuration config) {
        this.config = config;
    }
    /**
     * 将已添加的映射器代理工厂加入到 HashMap
     */
   private  final  HashMap<Class<?>,MapperProxyFactory<?>> knownMappers=  new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        /* Mapper 必须是接口才会注册 */
        if (type.isInterface()) {
            if (hasMapper(type)) {
                // 如果重复添加了，报错
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }


}
