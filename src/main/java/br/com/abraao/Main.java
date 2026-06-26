package br.com.abraao;

import br.com.abraao.domain.MainMemory;
import br.com.abraao.domain.PageTable;
import br.com.abraao.service.SimulatedProcessService;
import br.com.abraao.service.MMUService;
import br.com.abraao.service.FIFOReplacementService;

import static br.com.abraao.util.ConsolePrinter.printConfigMemory;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PageTable pageTable = new PageTable();
        MainMemory mainMemory = new MainMemory();
        FIFOReplacementService fifo = new FIFOReplacementService();

        MMUService mmu = new MMUService(pageTable, mainMemory, fifo);

        printConfigMemory();

        SimulatedProcessService p1 = new SimulatedProcessService(1, 15, mmu);
        SimulatedProcessService p2 = new SimulatedProcessService(2, 15, mmu);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}