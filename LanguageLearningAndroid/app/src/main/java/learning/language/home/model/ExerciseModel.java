package learning.language.home.model;

/**
 * Created by Cristi on 1/3/2017.
 */

public class ExerciseModel {
    private String word;
    private boolean answerd;
    private String answer;
    private String trueAnswer;

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getAnswer() {

        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAnswerd() {

        return answerd;
    }

    public void setAnswerd(boolean answerd) {
        this.answerd = answerd;
    }

    public String getWord() {

        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
