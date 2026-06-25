package br.com.abraao.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TranslationResult {

    private int virtualAddress;
    private int pageNumber;
    private int frameNumber;
    private int offset;
    private int physicalAddress;
    private boolean pageFault;
}
