package br.com.abraao.service;

import br.com.abraao.domain.Frame;
import br.com.abraao.domain.MainMemory;
import br.com.abraao.domain.PageTable;
import br.com.abraao.domain.PageTableEntry;
import br.com.abraao.domain.TranslationResult;
import br.com.abraao.service.interfaces.PageReplacementDelegate;
import lombok.AllArgsConstructor;

import static br.com.abraao.domain.enums.ConstantsEnum.PAGE_SIZE;
import static java.util.Objects.isNull;

@AllArgsConstructor
public class MMUService {

    private final PageTable pageTable;
    private final MainMemory mainMemory;
    private final PageReplacementDelegate PageReplacementAlgorithm;

    public synchronized TranslationResult translate(int virtualAddress) {
        int page = virtualAddress / PAGE_SIZE.getValue();
        int offset = virtualAddress % PAGE_SIZE.getValue();

        PageTableEntry entry = pageTable.getEntry(page);
        boolean pageFault = false;

        if (!entry.isPresent()) {
            pageFault = true;
            loadPage(page, entry);
        }

        int frame = entry.getFrameNumber();
        int physicalAddress = frame * PAGE_SIZE.getValue() + offset;

        return TranslationResult.builder()
                .virtualAddress(virtualAddress)
                .pageNumber(page)
                .frameNumber(frame)
                .offset(offset)
                .physicalAddress(physicalAddress)
                .pageFault(pageFault)
                .build();
    }

    private void loadPage(int page, PageTableEntry entry) {
        Frame frame = mainMemory.findFreeFrame();

        if (isNull(frame)) {
            PageReplacementAlgorithm.replace(page, mainMemory, pageTable);
            return;
        }

        frame.setOccupied(true);
        frame.setPageNumber(page);

        entry.setPresent(true);
        entry.setFrameNumber(frame.getId());

        PageReplacementAlgorithm.pageLoaded(page);
    }
}
