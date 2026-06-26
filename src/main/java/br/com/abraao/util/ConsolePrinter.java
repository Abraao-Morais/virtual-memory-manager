package br.com.abraao.util;

import br.com.abraao.domain.Frame;
import br.com.abraao.domain.MainMemory;
import br.com.abraao.domain.TranslationResult;

import java.util.Queue;

import static br.com.abraao.domain.enums.ConstantsEnum.MAIN_MEMORY_SIZE;
import static br.com.abraao.domain.enums.ConstantsEnum.NUMBER_OF_FRAMES;
import static br.com.abraao.domain.enums.ConstantsEnum.NUMBER_OF_PAGES;
import static br.com.abraao.domain.enums.ConstantsEnum.PAGE_SIZE;
import static br.com.abraao.domain.enums.ConstantsEnum.VIRTUAL_MEMORY_SIZE;

public class ConsolePrinter  {

    public static void printConfigMemory() {
        System.out.println();
        System.out.println("======================================");
        System.out.println("MEMORY CONFIGS");
        System.out.println("--------------------------------------");
        System.out.println("Main Memory      : " + MAIN_MEMORY_SIZE.getValue() / 1024 + " KB");
        System.out.println("Virtual Memory   : " + VIRTUAL_MEMORY_SIZE.getValue() / 1024 + " KB");
        System.out.println("Page Size        : " + PAGE_SIZE.getValue() / 1024 + " KB");
        System.out.println("Number of Frames : " + NUMBER_OF_FRAMES.getValue());
        System.out.println("Number of Pages  : " + NUMBER_OF_PAGES.getValue());
    }

    public static synchronized void printAccess(int processId, TranslationResult result, MainMemory mainMemory, Queue<Integer> queue) {
        System.out.println();
        System.out.println("======================================");
        System.out.println("PROCESS " + processId);
        System.out.println("--------------------------------------");
        System.out.println("Virtual Address  : " + result.getVirtualAddress());
        System.out.println("Page Number      : " + result.getPageNumber());
        System.out.println("Offset           : " + result.getOffset());
        System.out.println("Frame            : " + result.getFrameNumber());
        System.out.println("Physical Address : " + result.getPhysicalAddress());

        if (result.isPageFault())
            System.out.println("Status           : PAGE FAULT");
        else
            System.out.println("Status           : PAGE HIT");

        printQueue(queue);
        printMainMemory(mainMemory);
    }

    public static synchronized void printMainMemory(MainMemory mainMemory) {
        System.out.println();
        System.out.println("MAIN MEMORY:");
        System.out.printf("%-10s%-10s\n", "FRAME", "PAGE");

        for (Frame frame : mainMemory.getFrames()) {
            String page = !frame.isOccupied() ? "-" : String.valueOf(frame.getPageNumber());
            System.out.printf("%-10d%-10s\n", frame.getId(), page);
        }
    }

    public static synchronized void printQueue(Queue<Integer> queue) {
        System.out.println();
        System.out.print("FIFO QUEUE: ");

        if (queue.isEmpty()) {
            System.out.println("[vazia]");
            return;
        }

        for (Integer page : queue)
            System.out.print("[" + page + "] -> ");

        System.out.println("X");
    }
}
