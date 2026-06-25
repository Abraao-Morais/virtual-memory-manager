package br.com.abraao.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConstantsEnum {

    PAGE_SIZE( 8 * 1024),
    MAIN_MEMORY_SIZE( 64 * 1024),
    VIRTUAL_MEMORY_SIZE(1024 * 1024),
    NUMBER_OF_FRAMES(MAIN_MEMORY_SIZE.getValue() / PAGE_SIZE.getValue()),
    NUMBER_OF_PAGES( VIRTUAL_MEMORY_SIZE.getValue() / PAGE_SIZE.getValue());

    private final int value;
}
