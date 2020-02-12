package com.eom.lifeCycle;

import com.eom.util.read.Readable;

import java.io.IOException;

public class EmpInit {
    private final Readable readable;

    public EmpInit(Readable readable) {
        this.readable = readable;
    }

    // 직원 정보 로드: 파일 → 메모리
    public void initialize() throws IOException {
        readable.readEmpList();
    }
}
