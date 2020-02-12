package com.eom.lifeCycle;

import com.eom.model.Employee;
import com.eom.model.EmployeeList;
import com.eom.util.print.Printable;

public class EmpManagement {
    private final Printable printable;

    // 출력 소스 초기화
    public EmpManagement(Printable printable) {
        this.printable = printable;
    }

    // 직원 등록
    public void addEmp(Employee employee) {
        EmployeeList.getEmployeeList().add(employee);
    }

    // 직원 목록
    public void printEmp() {
        printable.printEmp();
        EmployeeList.getEmployeeList().stream().
                forEach(employee -> {
                    printable.printEmp(employee);
                });
    }

    // 직원 상세
    public void printEmpDetail(Integer empNo) {
        printable.printEmp();
        EmployeeList.getEmployeeList().stream()
                .filter(employees -> employees.findEmpByEmpNo(empNo) != null)
                .forEach(employee -> {
                    printable.printEmp(employee);
                });
    }

    // 직원 수정
    // 과도한 매개변수(∵ Employee는 생성 용도)
    public void modifyEmp(Integer empNo, String empName, String phoneNum, String empRank, String email) {
        EmployeeList.getEmployeeList().stream()
                .filter(employees -> employees.findEmpByEmpNo(empNo) != null)
                .forEach(employee -> {
                    employee.setEmpName(empName).setPhoneNum(phoneNum).setEmpRank(empRank).setEmail(email);
                });
    }

    // 직원 삭제
    public void deleteEmp(Integer empNo) {
        EmployeeList.getEmployeeList().stream()
                .filter(employees -> employees.findEmpByEmpNo(empNo) != null)
                .forEach(employee -> {
                    employee.setEmpName("-").setPhoneNum("-").setEmpRank("-").setEmail("-");
                });
    }
}
