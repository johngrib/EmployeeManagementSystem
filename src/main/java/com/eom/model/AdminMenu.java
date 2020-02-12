package com.eom.model;

import java.util.List;

public enum AdminMenu {
    EXIT("종료"),
    INPUT_DATA("자료 입력"),
    PRINT_LIST("목록 출력"),
    PRINT("상세 정보 출력"),
    EDIT("수정"),
    DELETE("삭제");

    private String description;

    AdminMenu(String description) {
        this.description = description;
    }

    final static List<AdminMenu> MENU = List.of(EXIT, INPUT_DATA, PRINT_LIST, PRINT, EDIT, DELETE);

    public static AdminMenu of(int selected) {
        if (selected < 0 || selected >= MENU.size()) {
            throw new IllegalArgumentException("지원하지 않는 메뉴 번호입니다.");
        }
        return MENU.get(selected);
    }

    public static String getMenuString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < MENU.size(); i++) {
            sb.append(String.format("%d: %s, ", i, MENU.get(i).description));
        }
        sb = sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
