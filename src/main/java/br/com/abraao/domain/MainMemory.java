package br.com.abraao.domain;

import lombok.Getter;

@Getter
public class MainMemory {

    private final Frame[] frames;

    public MainMemory() {
        frames = new Frame[8];

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
}
