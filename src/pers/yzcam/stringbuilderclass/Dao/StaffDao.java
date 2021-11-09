package pers.yzcam.stringbuilderclass.Dao;

import java.util.Map;

/**
 * Staff数据库处理类
 */
public class StaffDao {
    /**
     * 数据库转换成语句
     *
     * @param args 目标数据库
     */
    public void findByArgs(Map<String, Object> args) {
        StringBuilder sqlBuilder = new StringBuilder("select * from staff ");

        if (args.size() != 0) {
            sqlBuilder.append("where 1=1 ");
            if (args.containsKey("name")) {
                sqlBuilder.append("and name = '").append(args.get("name")).append("' ");
            }
            if (args.containsKey("gender")) {
                sqlBuilder.append("and gender = '").append(args.get("gender")).append("' ");
            }
            if (args.containsKey("address")) {
                sqlBuilder.append("and address = '").append(args.get("address")).append("' ");
            }
            if (args.containsKey("post")) {
                sqlBuilder.append("and post = ").append(args.get("post"));
            }
        }

        System.out.println("最终的sql: " + sqlBuilder);
    }

}
