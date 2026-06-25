package br.com.abraao.domain;

import br.com.abraao.service.MMUService;
import lombok.AllArgsConstructor;
import java.util.concurrent.ThreadLocalRandom;

import static br.com.abraao.domain.enums.ConstantsEnum.VIRTUAL_MEMORY_SIZE;

@AllArgsConstructor
public class SimulatedProcess implements Runnable {

    private final int pid;
    private final int accesses;
    private final MMUService mmu;

    @Override
    public void run() {
        for (int i = 0; i < accesses; i++) {
            int virtualAddress = generateAddress();

            TranslationResult result = mmu.translate(virtualAddress);
            print(result);
            sleep();
        }
    }

    private int generateAddress() {
        return ThreadLocalRandom.current().nextInt(VIRTUAL_MEMORY_SIZE.getValue());
    }

    private void print(TranslationResult result) {
        System.out.printf(
                "[P%d] VA=%d | Página=%d | Frame=%d | PA=%d | Fault=%s%n",
                pid,
                result.getVirtualAddress(),
                result.getPageNumber(),
                result.getFrameNumber(),
                result.getPhysicalAddress(),
                result.isPageFault()
        );
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