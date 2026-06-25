package br.com.abraao.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageTable {

    private final PageTableEntry[] entries;

    public PageTable() {
        entries = new PageTableEntry[128];

        for (int i = 0; i < entries.length; i++) {
            entries[i] = new PageTableEntry(i);
        }
    }

    public PageTableEntry getEntry(int pageNumber) {
        return entries[pageNumber];
    }
}
