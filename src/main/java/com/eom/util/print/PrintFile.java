package com.eom.util.print;

import com.eom.model.Employee;
import com.eom.util.format.EmpNoFormat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrintFile implements Printable {
    // 설정 파일 분리 필요
    // 상수 but 변경 가능성 방지(∴ private)
    private static final String FILE_PATH = "C:\\Users\\NT930QAA\\workspace-employeeManagement\\EmployeeManagementSystem\\emp.txt";

    private final BufferedWriter writer;

    public PrintFile() throws IOException {
        writer = new BufferedWriter(new FileWriter(FILE_PATH, false));
    }

    @Override
    public void printEmp() {
        try {
            writer.write("직원번호" + "\t\t" + "이름" + "\t" + "전화번호" + "\t\t" + "직급" + "\t" + "이메일" + "\n");
            writer.write("========================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printEmp(Employee employee) {
        try {
            writer.write("\n" + EmpNoFormat.changeNumberFormat(employee.getEmpNo()) + "\t" + employee.getEmpName() + "\t" + employee.getPhoneNum() + "\t" + employee.getEmpRank() + "\t" + employee.getEmail());
            writer.flush();     // 안 써주면 파일 공백 덮어씌워짐(∵ 루프 한 바퀴 더 돔)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
