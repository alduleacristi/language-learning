package learning.language.home.languagelearning;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import language.learning.dto.ArticleDTO;
import learning.language.home.laguagelearning.service.ArticleService;

public class AddWordsActivity extends MenuBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);

        Toolbar homeToolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(homeToolbar);

        Spinner spinner = (Spinner) findViewById(R.id.wordType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.word_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final Button addWordButton = (Button) findViewById(R.id.addWordButton);

        addWordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText gerWord = (EditText) findViewById(R.id.germanWord);
                EditText roWord = (EditText) findViewById(R.id.englishWord);


                String message = "Get all articles: ";
                ArticleService articleService = new ArticleService();
                List<ArticleDTO> articles = articleService.getAllArticles();
                Toast.makeText(AddWordsActivity.this, articles.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
