package pers.yzcam.sensible.util;

import pers.yzcam.sensible.exception.TypeNotSupportedException;

/**
 * @author cat
 */
public class TypeManagement {
    public void managementType(Object object) throws TypeNotSupportedException {
        if (!(object instanceof BaseType)) {
            throw new TypeNotSupportedException("对象参数 'object' 不符合是 pers.yzcam.sensible.util.BaseType 类型");
        }
        System.out.println("处理成功");
    }
}
