package com.rodrigoramos.sistemabancarioapi.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
    private static final long serialVersionUID = 4471777119419172870L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String path;

}
