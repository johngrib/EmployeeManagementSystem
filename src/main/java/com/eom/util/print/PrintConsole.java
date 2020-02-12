package com.eom.util.print;

import com.eom.model.Employee;
import com.eom.util.format.EmpNoFormat;

public class PrintConsole implements Printable {
    @Override
    public void printEmp() {
        System.out.println("직원번호" + "\t\t" + "이름" + "\t\t" + "전화번호" + "\t\t" + "직급" + "\t\t" + "이메일");
        System.out.println("================================================================");
    }

    @Override
    public void printEmp(Employee employee) {
        System.out.println(EmpNoFormat.changeNumberFormat(employee.getEmpNo()) + "\t\t\t\t" + employee.getEmpName() + "\t\t" + employee.getPhoneNum() + "\t" + employee.getEmpRank() + "\t\t" + employee.getEmail());
    }
}
