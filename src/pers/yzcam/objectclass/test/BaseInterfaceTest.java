package pers.yzcam.objectclass.test;

import pers.yzcam.objectclass.interface_.BaseInterface;
import pers.yzcam.objectclass.interface_.impl.BaseInterfaceImpl;
import pers.yzcam.objectclass.interface_.impl.BaseInterfaceImplA;

public class BaseInterfaceTest {
    public static void main(String[] args) {
        BaseInterface baseInterface = new BaseInterfaceImpl();
        BaseInterface baseInterface1 = new BaseInterfaceImplA();

        int[] ints = {1, 2};
        int sum = (Integer) baseInterface.superMethod(ints);
        System.out.println(sum);
    }
}
