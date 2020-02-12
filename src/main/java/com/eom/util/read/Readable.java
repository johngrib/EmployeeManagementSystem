package com.eom.util.read;

import java.io.IOException;

public interface Readable {
    public void readEmpList() throws IOException;
    public Integer getLastEmpNo();
}
