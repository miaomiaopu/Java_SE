package pers.yzcam.objectclass.interface_.impl;

import pers.yzcam.objectclass.interface_.BaseInterface;

public class BaseInterfaceImplA implements BaseInterface {

    /**
     * 超级方法
     *
     * @param obj 一个对象
     * @return 一个对象
     */
    @Override
    public Object superMethod(Object obj) {
        String str = (String) obj;
        return str.length() >= 6 && str.length() <= 16;
    }
}
