package learning.language.home.languagelearning;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import language.learning.dto.NounDTO;
import learning.language.home.laguagelearning.service.NounService;
import learning.language.home.model.ExerciseModel;

public class NounGerRoExerciseActivity extends MenuBaseActivity {
    private static final String GERMAN_WORD = "German word: ";
    private static final String RIGHT_ANSWER = "Right answer: ";

    private final Gson gson = new Gson();
    private List<ExerciseModel> model = null;
    private Button previousButton = null;
    private Button nextButton = null;
    private Button checkButton = null;
    private Button restartButton = null;
    private TextView germanWord = null;
    private TextView trueAnswer = null;
    private TextView answer = null;
    private ImageView iconAnswer = null;
    private Integer currentNoun = 0;
    private Long nrOfWords;

    private void initializeActivity(String nounsJSON) {
        Type nounType = new TypeToken<List<NounDTO>>() {
        }.getType();
        List<NounDTO> nounDTOs = gson.fromJson(nounsJSON, nounType);

        model = new ArrayList<>();
        for (NounDTO noun : nounDTOs) {
            ExerciseModel exerciseModel = new ExerciseModel();
            exerciseModel.setWord(noun.getGermanWord());
            exerciseModel.setTrueAnswer(noun.getRomanianWord());

            model.add(exerciseModel);
        }

        germanWord = (TextView) findViewById(R.id.germanWord);
        germanWord.setText(GERMAN_WORD + nounDTOs.get(currentNoun).getGermanWord());

        previousButton = (Button) findViewById(R.id.previousButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        checkButton = (Button) findViewById(R.id.checkAnswer);
        trueAnswer = (TextView) findViewById(R.id.trueAnswer);
        iconAnswer = (ImageView) findViewById(R.id.iconAnswer);
        answer = (TextView) findViewById(R.id.answer);
        restartButton = (Button) findViewById(R.id.restartButton);

        trueAnswer.setVisibility(View.INVISIBLE);
        iconAnswer.setVisibility(View.INVISIBLE);
    }


    private void settingsForTrueAnswer() {
        Drawable okIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.ok, null);
        iconAnswer.setImageDrawable(okIcon);
        iconAnswer.setVisibility(View.VISIBLE);
        trueAnswer.setVisibility(View.INVISIBLE);
    }

    private void settingsForFalseAnswer() {
        Drawable okIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.not_ok, null);
        iconAnswer.setImageDrawable(okIcon);
        iconAnswer.setVisibility(View.VISIBLE);
        iconAnswer.setVisibility(View.VISIBLE);
        trueAnswer.setVisibility(View.VISIBLE);
        trueAnswer.setText(RIGHT_ANSWER + model.get(currentNoun).getTrueAnswer());
    }

    private void settingsForNoAnswer() {
        iconAnswer.setVisibility(View.INVISIBLE);
        trueAnswer.setVisibility(View.INVISIBLE);
    }

    private void addActionForPreviousButton() {
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNoun--;
                if (currentNoun < model.size() - 1) {
                    nextButton.setEnabled(true);
                }
                if (currentNoun == 0) {
                    previousButton.setEnabled(false);
                }

                if (model.get(currentNoun).isAnswerd()) {
                    checkButton.setEnabled(false);
                } else {
                    checkButton.setEnabled(true);
                }

                if (model.get(currentNoun).isAnswerd()) {
                    answer.setText(model.get(currentNoun).getAnswer());
                    String answer = model.get(currentNoun).getAnswer().toLowerCase().trim();
                    String trueAnswer = model.get(currentNoun).getTrueAnswer().toLowerCase().trim();

                    if (trueAnswer.equals(answer)) {
                        settingsForTrueAnswer();
                    } else {
                        settingsForFalseAnswer();
                    }
                } else {
                    settingsForNoAnswer();
                    answer.setText(null);
                }

                germanWord.setText(GERMAN_WORD + model.get(currentNoun).getWord());
            }
        });
    }

    private void addActionForNextButton() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNoun++;
                if (currentNoun > 0) {
                    previousButton.setEnabled(true);
                }
                if (currentNoun == model.size() - 1) {
                    nextButton.setEnabled(false);
                }

                if (model.get(currentNoun).isAnswerd()) {
                    checkButton.setEnabled(false);
                } else {
                    checkButton.setEnabled(true);
                }

                if (model.get(currentNoun).isAnswerd()) {
                    answer.setText(model.get(currentNoun).getAnswer());
                    String answer = model.get(currentNoun).getAnswer().toLowerCase().trim();
                    String trueAnswer = model.get(currentNoun).getTrueAnswer().toLowerCase().trim();

                    if (trueAnswer.equals(answer)) {
                        settingsForTrueAnswer();
                    } else {
                        settingsForFalseAnswer();
                    }
                } else {
                    settingsForNoAnswer();
                    answer.setText(null);
                }

                germanWord.setText(GERMAN_WORD + model.get(currentNoun).getWord());
            }
        });
    }

    private void addActionForCheckButton() {
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strAnswer = answer.getText().toString();
                model.get(currentNoun).setAnswer(strAnswer);

                if (strAnswer.trim().equals("")) {
                    Toast.makeText(NounGerRoExerciseActivity.this, "The answer can not be null", Toast.LENGTH_SHORT).show();
                }

                String germanWord = model.get(currentNoun).getWord().toLowerCase().trim();
                String answer = model.get(currentNoun).getAnswer().toLowerCase().trim();
                String trueAnswerStr = model.get(currentNoun).getTrueAnswer().toLowerCase().trim();

                model.get(currentNoun).setAnswerd(true);

                if (answer.equals(trueAnswerStr)) {
                    settingsForTrueAnswer();
                } else {
                    settingsForFalseAnswer();
                }
            }
        });
    }

    private void addActionForRestartButton() {
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NounService nounService = new NounService();
                String nounsJSON = nounService.getRandomNouns(nrOfWords);

                initializeActivity(nounsJSON);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noun_ger_ro_exercise);

        Toolbar homeToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(homeToolbar);

        String nounsJSON = (String) getIntent().getSerializableExtra("nouns");
        nrOfWords = (Long) getIntent().getSerializableExtra("nrOfWords");

        initializeActivity(nounsJSON);
        addActionForPreviousButton();
        addActionForNextButton();
        addActionForCheckButton();
        addActionForRestartButton();
    }

}
