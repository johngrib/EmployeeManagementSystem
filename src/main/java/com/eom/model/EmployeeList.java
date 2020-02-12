package com.eom.model;

import java.util.ArrayList;

public class EmployeeList {
    // static → singleton(전역 변수와 마찬가지로 어디서든 액세스 가능)
    private static final ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
}
