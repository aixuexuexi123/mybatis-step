package mybatisStep.builder;

import mybatisStep.session.Configuration;

/**
 * @Description 构建器的基类，建造者模式
 * @Date 2024/5/1 10:47
 * @Created by lenovo
 */
public abstract  class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
