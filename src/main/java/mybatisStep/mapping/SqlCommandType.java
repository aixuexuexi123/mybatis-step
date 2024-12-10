package mybatisStep.mapping;

/**
 * @Description SQL 指令类型
 * @Date 2024/5/1 15:27
 * @Created by lenovo
 */
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
