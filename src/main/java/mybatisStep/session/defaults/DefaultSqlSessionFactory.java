package mybatisStep.session.defaults;

import mybatisStep.binding.MapperRegistry;
import mybatisStep.session.SqlSession;
import mybatisStep.session.SqlSessionFactory;

/**
 * @Description 默认qlSessionFactory 实现类
 * @Date 2024/4/18 13:20
 * @Created by lenovo
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
