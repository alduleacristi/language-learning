package learning.language.home.languagelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import language.learning.dto.NounDTO;
import learning.language.home.exception.RemoteInvocationFailed;
import learning.language.home.laguagelearning.service.NounService;

public class NounExerciseActivity extends MenuBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noun_exercise);

        Toolbar homeToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(homeToolbar);

        final NumberPicker np = (NumberPicker) findViewById(R.id.nrOfNouns);
        String[] nums = new String[10];
        for (int i = 3; i < nums.length; i++)
            nums[i] = Integer.toString(i);

        np.setMinValue(3);
        np.setMaxValue(15);
        np.setWrapSelectorWheel(true);
        np.setValue(5);

        Button germanToRomanianButton = (Button) findViewById(R.id.GermanToRomanian);

        germanToRomanianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int nrOfWords = np.getValue();
                    NounService nounService = new NounService(NounExerciseActivity.this);
                    String nounJSON = nounService.getRandomNouns((long) nrOfWords);

                    Intent goToGerRoNounExercise = new Intent(NounExerciseActivity.this, NounGerRoExerciseActivity.class);
                    goToGerRoNounExercise.putExtra("nouns", nounJSON);
                    goToGerRoNounExercise.putExtra("noOfWords", nrOfWords);
                    startActivity(goToGerRoNounExercise);
                } catch (RemoteInvocationFailed remoteInvocationFailed) {
                    Toast.makeText(NounExerciseActivity.this, remoteInvocationFailed.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
