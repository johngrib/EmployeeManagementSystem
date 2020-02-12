package com.eom;

import com.eom.exception.EmpNoExcessException;
import com.eom.lifeCycle.EmpDestroy;
import com.eom.lifeCycle.EmpInit;
import com.eom.lifeCycle.EmpManagement;
import com.eom.model.AdminMenu;
import com.eom.model.Employee;
import com.eom.util.print.PrintConsole;
import com.eom.util.print.PrintFile;
import com.eom.util.read.ReadFile;
import com.eom.util.read.Readable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.eom.model.AdminMenu.*;

public class EmpMain {
    public static void main(String[] args) {
        // 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 초기화
        Readable readable = null;
        final String dataFilePath = getDataFilePath();

        try {
            readable = new ReadFile(dataFilePath);
        } catch (IOException e) {
            System.out.println("파일 연결-1 실패");
            e.printStackTrace();
        }
        EmpInit empInit = new EmpInit(readable);
        try {
            empInit.initialize();
        } catch (IOException e) {
            System.out.println("파일 초기화 실패");
            e.printStackTrace();
        }
        Employee.setEmpNoCounter(readable.getLastEmpNo());

        // 출력/저장 소스 지정
        EmpManagement empManagement = new EmpManagement(new PrintConsole());
        EmpDestroy empDestroy = null;
        try {
            empDestroy = new EmpDestroy(new PrintFile());
        } catch (IOException e) {
            System.out.println("파일 연결-2 실패");
            e.printStackTrace();
        }

        System.out.println("프로그램 시작");
        while (true) {
            System.out.println("메뉴 선택: ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (AdminMenu.of(menu)) {
                case EXIT:
                    exitMenu(empDestroy);
                    return;
                case INPUT_DATA:
                    inputDataProcess(scanner, empManagement);
                    break;
                case PRINT_LIST:
                    printEmployeeList(empManagement);
                    break;
                case PRINT:
                    printEmployee(scanner, empManagement);
                    break;
                case EDIT:
                    editEmployee(scanner, empManagement);
                    break;
                case DELETE:
                    deleteEmployee(scanner, empManagement);
                    break;
            }
        }
    }

    private static void deleteEmployee(Scanner scanner, EmpManagement empManagement) {
        System.out.println("직원 삭제");
        System.out.println("직원번호: ");
        Integer empNo = scanner.nextInt();
        scanner.nextLine();

        empManagement.deleteEmp(empNo);
    }

    private static void editEmployee(Scanner scanner, EmpManagement empManagement) {
        System.out.println("직원 정보 수정");
        System.out.println("직원번호: ");
        Integer empNo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("이름: ");
        String empName = scanner.nextLine();
        System.out.println("전화번호: ");
        String phoneNum = scanner.nextLine();
        System.out.println("직급: ");
        String empRank = scanner.nextLine();
        System.out.println("이메일: ");
        String email = scanner.nextLine();

        empManagement.modifyEmp(empNo, empName, phoneNum, empRank, email);
    }

    private static void printEmployee(Scanner scanner, EmpManagement empManagement) {
        Integer empNo;
        System.out.println("직원 상세 정보 출력");
        System.out.println("직원번호: ");
        empNo = scanner.nextInt();
        scanner.nextLine();

        empManagement.printEmpDetail(empNo);
    }

    private static void printEmployeeList(EmpManagement empManagement) {
        System.out.println("직원 목록 출력");
        empManagement.printEmp();
    }

    private static void inputDataProcess(Scanner scanner, EmpManagement empManagement) {
        System.out.println("이름: ");
        String empName = scanner.nextLine();
        System.out.println("전화번호: ");
        String phoneNum = scanner.nextLine();
        System.out.println("직급: ");
        String empRank = scanner.nextLine();
        System.out.println("이메일: ");
        String email = scanner.nextLine();

        Employee employee = null;
        // throw 대신 try-catch문 사용
        try {
            employee = new Employee
                    .Builder(empName, phoneNum, empRank)
                    .email(email)
                    .build();
        } catch (EmpNoExcessException e) {
            System.out.println("직원 추가 중 에러 발생: " + e.getMessage());
            e.printStackTrace();    // ∴ 프로그램 종료
        }

        empManagement.addEmp(employee);
    }

    private static void exitMenu(EmpDestroy empDestroy) {
        // 메모리 → 파일
        empDestroy.destroy();
        System.out.println("시스템 종료");
    }

    private static String getDataFilePath() {
        try {
            final URL resource = EmpMain.class.getResource("/emp.txt");
            return Paths.get(resource.toURI()).toAbsolutePath().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
