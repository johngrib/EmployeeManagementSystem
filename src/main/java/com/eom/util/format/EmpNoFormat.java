package com.eom.util.format;

public class EmpNoFormat {
    // 직원 목록 저장 시 실행
    // 직원 번호 세자리로 변경(000 ~ 999)
    public static String changeNumberFormat(Integer empNo) {
        if (empNo < 10) {
            return "00" + Integer.toString(empNo);
        } else if (empNo >= 10 && empNo < 100) {
            return "0" + Integer.toString(empNo);
        }
        // empNo >= 100 && empNo < 1000
        return Integer.toString(empNo);
    }
}
