package mybatisStep.session;

/**
 * @Description 工厂模式接口，构建SqlSession的工厂
 * @Date 2024/4/18 13:19
 * @Created by lenovo
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
