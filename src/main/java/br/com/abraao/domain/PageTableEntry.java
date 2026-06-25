package br.com.abraao.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageTableEntry {

    private int pageNumber;
    private boolean present;
    private Integer frameNumber;

    public PageTableEntry(int pageNumber) {
        this.pageNumber = pageNumber;
        this.present = false;
    }
}
