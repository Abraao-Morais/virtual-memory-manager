package br.com.abraao.service.interfaces;

import br.com.abraao.domain.Frame;
import br.com.abraao.domain.MainMemory;
import br.com.abraao.domain.PageTable;

public interface PageReplacementDelegate {

    void pageLoaded(int page);
    Frame replace(int newPage, MainMemory memory, PageTable pageTable);
}
