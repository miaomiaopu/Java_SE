package pers.yzcam.synchronize;

/**
 * @author cat
 */
public class CommandDaoRunnableDelete extends Thread {
    private CommandDao dao;

    public CommandDaoRunnableDelete() {
    }

    public CommandDaoRunnableDelete(CommandDao dao) {
        this.dao = dao;
    }

    @Override
    public void run() {
        dao.deleteData();
    }
}
