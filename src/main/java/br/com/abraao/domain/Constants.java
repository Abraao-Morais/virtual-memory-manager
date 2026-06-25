package br.com.abraao.domain;

public class Constants {

    public static final int PAGE_SIZE = 8 * 1024;
    public static final int MAIN_MEMORY_SIZE = 64 * 1024;
    public static final int VIRTUAL_MEMORY_SIZE = 1024 * 1024;
    public static final int NUMBER_OF_FRAMES = MAIN_MEMORY_SIZE / PAGE_SIZE;
    public static final int NUMBER_OF_PAGES = VIRTUAL_MEMORY_SIZE / PAGE_SIZE;
}
