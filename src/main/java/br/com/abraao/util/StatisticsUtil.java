package br.com.abraao.util;

import static br.com.abraao.domain.enums.ConstantsEnum.MAIN_MEMORY_SIZE;
import static br.com.abraao.domain.enums.ConstantsEnum.NUMBER_OF_FRAMES;
import static br.com.abraao.domain.enums.ConstantsEnum.NUMBER_OF_PAGES;
import static br.com.abraao.domain.enums.ConstantsEnum.PAGE_SIZE;
import static br.com.abraao.domain.enums.ConstantsEnum.VIRTUAL_MEMORY_SIZE;

public class StatisticsUtil {

    public static void printConfigMemory() {
        System.out.println("======== SIMULADOR DE MEMÓRIA VIRTUAL ========");
        System.out.println("Memória Principal: " + MAIN_MEMORY_SIZE.getValue() / 1024 + " KB");
        System.out.println("Memória Virtual: " + VIRTUAL_MEMORY_SIZE.getValue() / 1024 + " KB");
        System.out.println("Tamanho da Página: " + PAGE_SIZE.getValue() / 1024 + " KB");
        System.out.println("Frames: " + NUMBER_OF_FRAMES.getValue());
        System.out.println("Páginas Virtuais: " + NUMBER_OF_PAGES.getValue());
    }
}
