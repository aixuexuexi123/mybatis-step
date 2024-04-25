package mybatisStep.session.defaults;

import mybatisStep.session.SqlSession;

/**
 * @Description 默认SqlSession实现类
 * @Date 2024/4/18 13:19
 * @Created by lenovo
 */
public class DefaultSqlSession  implements SqlSession {
    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return null;
    }
}
