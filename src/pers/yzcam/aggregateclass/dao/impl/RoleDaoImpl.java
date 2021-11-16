package pers.yzcam.aggregateclass.dao.impl;

import pers.yzcam.aggregateclass.dao.RoleDao;
import pers.yzcam.aggregateclass.db.DataBase;

import java.util.List;
import java.util.Map;

/**
 * @author cat
 */
public class RoleDaoImpl implements RoleDao {

    @Override
    public List<Object> listRoleList() {
        return DataBase.getRoleMaps();
    }

    @Override
    public boolean addRole(Map<Object, Object> roleMap) {
        List<Object> roleList = DataBase.getRoleMaps();
        return roleList.add(roleMap);
    }

    @Override
    public void updateStatusToDisable(Integer roleId) {
        List<Object> roleList = DataBase.getRoleMaps();
        for (int i = 0; i < roleList.size(); i++) {
            Map<Object, Object> tempMap = (Map<Object, Object>) roleList.get(i);
            if (tempMap.get("id").equals(roleId)) {
                tempMap.put("status", 1);
                break;
            }
        }
    }
}
