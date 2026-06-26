package br.com.abraao.service;

import br.com.abraao.domain.TranslationResult;
import lombok.AllArgsConstructor;
import java.util.concurrent.ThreadLocalRandom;

import static br.com.abraao.domain.enums.ConstantsEnum.VIRTUAL_MEMORY_SIZE;
import static br.com.abraao.util.ConsolePrinter.printAccess;

@AllArgsConstructor
public class SimulatedProcessService implements Runnable {

    private final int pid;
    private final int accesses;
    private final MMUService mmu;

    @Override
    public void run() {
        for (int i = 0; i < accesses; i++) {
            int virtualAddress = generateAddress();
            TranslationResult result = mmu.translate(virtualAddress);
            printAccess(this.pid, result, mmu.getMainMemory(), mmu.getPageReplacementAlgorithm().getQueue());
            sleep();
        }
    }

    private int generateAddress() {
        return ThreadLocalRandom.current().nextInt(VIRTUAL_MEMORY_SIZE.getValue());
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}