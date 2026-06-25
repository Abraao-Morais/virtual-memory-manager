package br.com.abraao.service;

import br.com.abraao.domain.Frame;
import br.com.abraao.domain.MainMemory;
import br.com.abraao.domain.PageTable;
import br.com.abraao.domain.PageTableEntry;
import br.com.abraao.service.interfaces.PageReplacementDelegate;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOReplacementService implements PageReplacementDelegate {

    private Queue<Integer> queue = new LinkedList<>();

    @Override
    public void pageLoaded(int page) {
        queue.offer(page);
    }

    @Override
    public Frame replace(int newPage, MainMemory memory, PageTable pageTable) {
        Integer victimPage = queue.poll();

        PageTableEntry victimEntry = pageTable.getEntry(victimPage);
        Integer victimFrame = victimEntry.getFrameNumber();

        victimEntry.setPresent(false);
        victimEntry.setFrameNumber(null);

        Frame frame = memory.getFrames()[victimFrame];
        frame.setPageNumber(newPage);

        PageTableEntry newEntry = pageTable.getEntry(newPage);

        newEntry.setPresent(true);
        newEntry.setFrameNumber(frame.getId());

        queue.offer(newPage);

        return frame;
    }
}