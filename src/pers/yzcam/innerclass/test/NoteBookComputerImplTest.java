package pers.yzcam.innerclass.test;

import pers.yzcam.innerclass.interface_.impl.NoteBookComputerImpl;

public class NoteBookComputerImplTest {
    public static void main(String[] args) {
        // 普通类的创建
        NoteBookComputerImpl noteBook = new NoteBookComputerImpl();
        NoteBookComputerImpl.Cpu cpu;
        cpu = noteBook.new Cpu();
        cpu.handleData();

        noteBook.useComputer(1.0, 2.0);
    }
}
