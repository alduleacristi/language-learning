package learning.language.home.languagelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.List;

import language.learning.dto.NounDTO;
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
                int nrOfWords = np.getValue();
                NounService nounService = new NounService();
                List<NounDTO> nounDTOs = nounService.getRandomNouns((long) nrOfWords);

                Toast.makeText(NounExerciseActivity.this, "" + nounDTOs.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
