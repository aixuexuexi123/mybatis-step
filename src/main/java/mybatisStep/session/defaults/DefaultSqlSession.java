package mybatisStep.session.defaults;

import mybatisStep.binding.MapperRegistry;
import mybatisStep.session.SqlSession;

/**
 * @Description 默认SqlSession实现类
 * @Date 2024/4/18 13:19
 * @Created by lenovo
 */
public class DefaultSqlSession  implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
