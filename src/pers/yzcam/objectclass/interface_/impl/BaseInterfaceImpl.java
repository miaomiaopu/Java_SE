package pers.yzcam.objectclass.interface_.impl;

import pers.yzcam.objectclass.interface_.BaseInterface;

/**
 * BaseInterface 实现类
 */
public class BaseInterfaceImpl implements BaseInterface {
    /**
     * 超级方法
     *
     * @param obj 一个对象
     * @return Integer 对象
     */
    @Override
    public Object superMethod(Object obj) {
        int[] ints = (int[]) obj;
        return ints.length > 1 ? ints[0] + ints[1] : 0;
    }
}
