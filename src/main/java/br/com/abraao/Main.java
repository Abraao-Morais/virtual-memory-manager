package br.com.abraao;

import br.com.abraao.domain.MainMemory;
import br.com.abraao.domain.PageTable;
import br.com.abraao.domain.SimulatedProcess;
import br.com.abraao.service.MMUService;
import br.com.abraao.service.interfaces.PageReplacementDelegate;
import br.com.abraao.service.FIFOReplacementService;

import static br.com.abraao.util.StatisticsUtil.printConfigMemory;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PageTable pageTable = new PageTable();
        MainMemory mainMemory = new MainMemory();
        PageReplacementDelegate fifo = new FIFOReplacementService();

        MMUService mmu = new MMUService(pageTable, mainMemory, fifo);

        printConfigMemory();
        mainMemory.printMemory();

        SimulatedProcess p1 = new SimulatedProcess(1, 15, mmu);
        SimulatedProcess p2 = new SimulatedProcess(2, 15, mmu);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        System.out.println("\n======== INICIANDO PROCESSOS ========\n");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\n======== RAM FINAL ========\n");

        mainMemory.printMemory();
    }
}