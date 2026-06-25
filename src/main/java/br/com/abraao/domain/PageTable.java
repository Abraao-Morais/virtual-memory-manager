package br.com.abraao.domain;

import lombok.Getter;
import lombok.Setter;

import static br.com.abraao.domain.enums.ConstantsEnum.NUMBER_OF_PAGES;

@Getter
@Setter
public class PageTable {

    private final PageTableEntry[] entries;

    public PageTable() {
        entries = new PageTableEntry[NUMBER_OF_PAGES.getValue()];

        for (int i = 0; i < entries.length; i++) {
            entries[i] = new PageTableEntry(i);
        }
    }

    public PageTableEntry getEntry(int pageNumber) {
        return entries[pageNumber];
    }
}
