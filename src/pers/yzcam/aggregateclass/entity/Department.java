package pers.yzcam.aggregateclass.entity;

import java.util.Date;

/**
 * 部门实体类
 *
 * @author cat
 */
public class Department {

    private String id;
    private String name;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
