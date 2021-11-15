package pers.yzcam.aggregateclass.dao;

import java.util.List;
import java.util.Map;

/**
 * @author cat
 */
public interface RoleDao {
    /**
     * 获取 Role 的信息
     * @return List List集合返回
     */
    List<Object> listRoleList();

    /**
     * 添加 Role 的信息
     * @param roleMap 源 Role
     * @return boolean 是否成功添加
     */
    boolean addRole(Map<Object,Object> roleMap);

    /**
     * 根据传入的 Id 来禁用某个用户组
     * @param roleId Id
     */
    void updateStatusToDisable(Integer roleId);
}
