package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

    // key : 학번, value : 성적정보
    private static final Map<Integer, Score> scoreMap;

    // 학번에 사용할 일련번호
    private static int sequence; // primary key로 사용할 학번을 체크해주는 변수, 0으로 자동 초기화

    // 정적변수를 초기화해줄 정적 블록
    static {
        scoreMap = new HashMap<>();
        Score stu1 = new Score("김자바", 100, 50, 70, ++sequence, 0, 0);
        Score stu2 = new Score("이부트", 33, 56, 0, ++sequence, 0, 0);
        Score stu3 = new Score("박디비", 88, 12, 54, ++sequence, 0, 0);

        scoreMap.put(stu1.getStudentNumber(), stu1);
        scoreMap.put(stu2.getStudentNumber(), stu2);
        scoreMap.put(stu3.getStudentNumber(), stu3);
    }

    // 실제로 구현해야 하는 기능들

    @Override
    public List<Score> findAll() {
        // scoreMap.values() // 이해 안가면 sout 내부에 넣고 체크하기.
        // 빈 ArrayList 리스트 생성
        List<Score> resultList = new ArrayList<Score>();
        // 반복문 이용해서 resultList에 Score 객체 채워넣기
        for(Score score : scoreMap.values()) {
            resultList.add(score);
        }
        //System.out.println(resultList);
        return resultList;
    }

    @Override
    public boolean save(Score score) {
        if(scoreMap.containsKey(score.getStudentNumber())){
            return false;// 이미 존재하는 학번이면 false 리턴
        }
        score.setStudentNumber(++sequence); // 사용된 적 없는 학번 정보 setter로 추가
        scoreMap.put(score.getStudentNumber(), score);
        return true;
    }

    @Override
    public boolean deleteByStudentNumber(int studentNumber) {
        if(!scoreMap.containsKey(studentNumber)) return false;
        scoreMap.remove(studentNumber);
        return true;
    }

    @Override
    public Score findByStudentNumber(int studentNumber) {
        return scoreMap.get(studentNumber);
    }




}
