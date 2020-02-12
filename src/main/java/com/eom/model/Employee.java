package com.eom.model;

import com.eom.exception.EmpNoExcessException;

public class Employee {
    // 직원 정보
    private final Integer empNo;    // 자동 증가
    private String empName;
    private String phoneNum;        // 정규표현식
    private String empRank;
    private String email;           // 정규표현식

    // 직원 번호 자동 증가(파일 목록 마지막 번호 초기화)
    private static Integer empNoCounter;

    // 직원 번호 초기화
    public static void setEmpNoCounter(Integer lastEmpNo) {
        empNoCounter = ++lastEmpNo;
    }

    private Employee(Builder builder) {
        this.empNo = builder._empNo;
        this.empName = builder._empName;
        this.phoneNum = builder._phoneNum;
        this.empRank = builder._empRank;
        this.email = builder._email;
    }

    // 입력 시 Null 방지 → Builder Pattern(∵ 점층적 생성자 패턴 단점 보완)
    // 코드 수정 및 가독성 보완
    public static class Builder {
        // 필수 인자
        private final Integer _empNo;
        private String _empName;
        private String _phoneNum;
        private String _empRank;

        // 선택 인자
        private String _email;

        // 초기화 시 생성자
        public Builder(Integer _empNo, String _empName, String _phoneNum, String _empRank) {
            this._empNo = _empNo;
            this._empName = _empName;
            this._phoneNum = _phoneNum;
            this._empRank = _empRank;
        }

        // 직원 추가 시 생성자
        public Builder(String _empName, String _phoneNum, String _empRank) throws EmpNoExcessException {
            if (empNoCounter == 999) {
                throw new EmpNoExcessException("1000명 이상의 직원 추가는 불가합니다.");
            }
            this._empNo = empNoCounter++;
            this._empName = _empName;
            this._phoneNum = _phoneNum;
            this._empRank = _empRank;
        }

        public Builder email(String email) {
            _email = email;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    // 상세/수정/삭제 시 반환
    public Employee findEmpByEmpNo(Integer empNo) {
        if (this.empNo.equals(empNo)) {
            return this;
        }
        return null;    // if문 제거 방법 고민
    }

    // 수정 필요(단축키: alt + ins)
    public Employee setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public Employee setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public Employee setEmpRank(String empRank) {
        this.empRank = empRank;
        return this;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    // 출력 위해 추가: 캡슐화 고민(∵ getter)
    public Integer getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmpRank() {
        return empRank;
    }

    public String getEmail() {
        return email;
    }
}
