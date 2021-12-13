package pers.yzcam.synchronize;

/**
 * @author cat
 */
public class CommandDaoRunnableAdd extends Thread {
    private CommandDao dao;

    public CommandDaoRunnableAdd() {
    }

    public CommandDaoRunnableAdd(CommandDao dao) {
        this.dao = dao;
    }

    @Override
    public void run() {
        dao.addData();
    }
}
