package br.com.abraao.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frame {

    private int id;
    private boolean occupied;
    private Integer pageNumber;

    public Frame(int id) {
        this.id = id;
        this.occupied = false;
    }
}
