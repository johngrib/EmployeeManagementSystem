package com.eom.exception;

import java.io.IOException;

public class PrintFileException extends IOException {
    public PrintFileException(String msg) {
        super(msg);
    }
}
