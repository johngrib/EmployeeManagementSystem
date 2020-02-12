package com.eom.util.read;

import com.eom.model.Employee;
import com.eom.model.EmployeeList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements Readable {
    private final BufferedReader reader;
    private Integer empNoCounter;

    public ReadFile(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    @Override
    public void readEmpList() throws IOException {  // readLine() → IOException
        String readTemp;
        String[] empTemp = new String[5];
        Employee employee;

        for (int i = 0; i < 2; i++) {
            readTemp = reader.readLine();    // 첫 두 줄 제외
        }
        while ((readTemp = reader.readLine()) != null) {
            empTemp = readTemp.split("\t");
            employee = new Employee
                    .Builder(Integer.parseInt(empTemp[0]), empTemp[1], empTemp[2], empTemp[3])
                    .email(empTemp[4])
                    .build();
            EmployeeList.getEmployeeList().add(employee);
            empNoCounter = Integer.parseInt(empTemp[0]);
        }
        System.out.println("파일 로드 완료");
    }

    @Override
    public Integer getLastEmpNo() {
        return empNoCounter;
    }
}
