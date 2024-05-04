package questiondao;

import hx.entity.Questions;

public interface QuestionDao {
    boolean addQuestion(Questions question);
    boolean findQuestion();
}
