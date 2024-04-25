package mybatisStep.session.defaults;

import mybatisStep.session.SqlSession;
import mybatisStep.session.SqlSessionFactory;

/**
 * @Description 默认qlSessionFactory 实现类
 * @Date 2024/4/18 13:20
 * @Created by lenovo
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    @Override
    public SqlSession openSession() {
        return null;
    }
}
