package yjjeon;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileTest {
    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() { // 단일 경로 커버 테스트
        Profile profile = new Profile("VP, Inc");
        Question question = new BooleanQuestion(1, "Got bonuses?");

        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);

        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Bool.TRUE); // 답변 (정답을 포함)
        Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch); // 답변과 가중치

        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() { // 위에 테스트와 2줄 빼고 모두 동일. 리팩토링 필요
        Profile profile = new Profile("VP, Inc");
        Question question = new BooleanQuestion(1, "Got milk?");

        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);

        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Bool.TRUE); // 답변 (정답을 포함)
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare); // 답변과 가중치

        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }

}