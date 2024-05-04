package hx.entity;

public class Questions {
    private String questionId;
    private String title;
    private String[] options;
    private String answer;
    public Questions(){}
    public Questions(String questionId, String title, String[] options, String answer) {
        this.questionId = questionId;
        this.title = title;
        this.options = options;
        this.answer = answer;
    }
}
