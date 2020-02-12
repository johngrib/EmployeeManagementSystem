package com.eom.lifeCycle;

import com.eom.model.EmployeeList;
import com.eom.util.print.Printable;

import java.io.IOException;

public class EmpDestroy {
    private final Printable printable;

    // 저장 소스 초기화(파일 → IOException)
    public EmpDestroy(Printable printable) throws IOException {
        this.printable = printable;
    }

    public void destroy() {
        printable.printEmp();
        EmployeeList.getEmployeeList().stream()
                .forEach(employee -> {
                    printable.printEmp(employee);
                });
    }
}
