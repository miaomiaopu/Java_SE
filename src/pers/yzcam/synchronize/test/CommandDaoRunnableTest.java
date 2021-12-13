package pers.yzcam.synchronize.test;

import pers.yzcam.synchronize.CommandDao;
import pers.yzcam.synchronize.CommandDaoRunnableAdd;
import pers.yzcam.synchronize.CommandDaoRunnableDelete;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 */
public class CommandDaoRunnableTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 100; i < 5000; i += 100) {
            list.add(i);
        }

        CommandDao dao = new CommandDao();
        dao.setList(list);

        CommandDaoRunnableAdd add = new CommandDaoRunnableAdd(dao);
        CommandDaoRunnableDelete delete = new CommandDaoRunnableDelete(dao);

        add.start();
        add.setPriority(Thread.MAX_PRIORITY);
        delete.start();

        dao.deleteData();
    }
}
