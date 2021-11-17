package pers.yzcam.generic.interface_;

import java.util.List;

/**
 * @author cat
 */
public interface BaseDao<T> {
    /**
     * 返回所有对象信息列表
     *
     * @return (List)列表
     */
    List<T> findAll();

    /**
     * 根据 id 返回信息
     *
     * @param id id
     * @return (T)当前对象
     */
    T findById(String id);

    /**
     * 根据 id 删除对象
     *
     * @param id id
     */
    void removeById(String id);

    /**
     * 根据 id 修改对象
     *
     * @param id id
     * @param t  源对象
     */
    void updateById(String id, T t);
}
