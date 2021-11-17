package pers.yzcam.generic.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cat
 */
public class GenericSupport {

    public static Set<String> getClassName(List<?> classList) {
        Set<String> classNameSet = new HashSet<>();
        /*
        此处只能用 Object 类
         */
        for (Object o : classList) {
            classNameSet.add(o.getClass().getName());
        }
        return classNameSet;
    }
}
