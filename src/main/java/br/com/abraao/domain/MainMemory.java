package br.com.abraao.domain;

import lombok.Getter;

import static br.com.abraao.domain.enums.ConstantsEnum.NUMBER_OF_FRAMES;

@Getter
public class MainMemory {

    private final Frame[] frames;

    public MainMemory() {
        frames = new Frame[NUMBER_OF_FRAMES.getValue()];

        for (int i = 0; i < frames.length; i++)
            frames[i] = new Frame(i);
    }

    public Frame findFreeFrame() {
        for (Frame frame : frames) {
            if (!frame.isOccupied())
                return frame;
        }
        return null;
    }

    public void printMemory() {
        System.out.println("============[MAIN MEMORY]============");
        for (Frame frame : frames) {
            if (frame.isOccupied())
                System.out.printf("Frame %d -> Página %d%n", frame.getId(), frame.getPageNumber());
            else
                System.out.printf("Frame %d -> Livre%n", frame.getId());
        }
        System.out.println("============[MAIN MEMORY]============");
    }
}
