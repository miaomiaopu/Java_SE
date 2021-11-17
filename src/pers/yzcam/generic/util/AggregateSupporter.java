package pers.yzcam.generic.util;

/**
 * @author cat
 */
public class AggregateSupporter<T> {

    public String getClassName(T t) {
        return t.getClass().getName();
    }
}
