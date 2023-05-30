package com.spring.mvc.chap04.entity;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor //모든 멤버변수를 다 요구하는 생성자
public class Score {

    private String name;//학생의 이름
    private int korScore; // 국어 성적
    private int engScore; // 영어 성적
    private int mathScore; // 수학 성적

    private int studentNumber; // 학번
    private int total; // 총점
    private double average; // 평균

}
