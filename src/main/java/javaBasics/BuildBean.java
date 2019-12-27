package javaBasics;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xinghaifang
 * Date: 2019/12/16
 * Time: 13:32
 */
public class BuildBean {
    private String tableName;
    private List<String> entityList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<String> entityList) {
        this.entityList = entityList;
    }
}
