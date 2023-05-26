package com.spring.mvc.chap04;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import com.spring.mvc.chap04.repository.ScoreRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreRepositoryTest {

    // 테스트 대상인 ScoreRepositoryImpl 클래스를 상단에 선언해둡니다.
    ScoreRepository repository = new ScoreRepositoryImpl();

    @Test
    public void ScoreRepositoryStaticVarTest(){
        // 접근 제한자가 public으로 풀려있는 동안만 실행 가능
        //System.out.println(ScoreRepositoryImpl.scoreMap);
        //System.out.println(ScoreRepositoryImpl.sequence);
    }

    // TDD 방법
    // 1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해 둔다.
    // 2. 테스트 코드 내부에 원하는 기능대로 작성되었을때 어떤 결과가 나올지 단언해둔다.
    // 3. 테스트가 통과될때까지, 원본 클래스를 수정하면서 계속 테스트 해본다.
    @Test
    public void findAllTest(){
        // GWT 패턴(AAA 패턴)
        // GIVEN (테스트를 위해 사전에 설정해야 하는 데이터를 선언하는 구간)

        // WHEN (테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성함)
        List<Score> result = repository.findAll();

        // THEN (테스트 결과가 이렇게 나올것이다 라는 단언을 합니다.)
        // 나는 result 내부에 3개의 Score가 있다고 단언한다.
        // scoreMap에 사전설정으로 3개의 데이터를 넣었으므로, 3개가 나와야 정상인 상황
        //System.out.println(result.size() == 3);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("저장소에서 2번 유저를 가져와서 이름과 국어성적 비교")
    public void findByStudentNumberTest(){
        // given(2번학생 정보가 실제 정보와 일치하는지 체크할 예정임)
        int studentNumber = 2;
        // when(2번 학생정보를 넣어 findByStudentNumber를 호출하고, 결과는 result에 저장
        Score result = repository.findByStudentNumber(studentNumber);
        // then(단언부에는 2개 이상의 단언문이 들어가도 상관 없음)
        // 2번유저를 얻어왔으므로, getter로 국어성적 조사시 33점일것이다.
        assertEquals(33, result.getKorScore());
        // 2번유저를 얻어왔으므로, getter로 이름 조사시 "이자바" 일것이다.
        assertEquals("이부트", result.getName());
    }

    @Test
    @DisplayName("없는 번호로 조회시 null이어야함.")
    public void notFindByStudentNumberTest(){
        // given
        int studentNumber = 99;
        // when
        Score result = repository.findByStudentNumber(studentNumber);
        //then
        assertNull(result);// 대상 변수가 null이면 통과, 아니면 실패
    }

    @Test
    @DisplayName("새로운 성적정보를 저장하면 전체 데이터의 개수는 4개가 된다.")
    public void saveTest(){
        // given
        Score score= new Score();
        score.setName("티디디");
        score.setKorScore(100);
        score.setEngScore(70);
        score.setMathScore(80);
        // when
        boolean boolResult = repository.save(score);
        List<Score> result = repository.findAll();// 저장한 후 전체 데이터 가져오기
        // then
        assertEquals(4, result.size());
        assertTrue(boolResult); // 실행이 잘 되면 true, 뭔가 오류나면 false
    }


}
