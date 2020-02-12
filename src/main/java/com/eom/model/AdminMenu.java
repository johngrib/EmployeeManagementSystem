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

    final static List<AdminMenu> menu = List.of(EXIT, INPUT_DATA, PRINT_LIST, PRINT, EDIT, DELETE);

    public static AdminMenu of(int selected) {
        if (selected < 0 || selected >= menu.size()) {
            throw new IllegalArgumentException("지원하지 않는 메뉴 번호입니다.");
        }
        return menu.get(selected);
    }
}
