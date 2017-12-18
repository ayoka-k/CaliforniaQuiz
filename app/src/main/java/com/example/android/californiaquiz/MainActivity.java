package com.example.android.californiaquiz;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.android.californiaquiz.QuizAnswers.FIFTH_QUESTION_RIGHT_OPTION;
import static com.example.android.californiaquiz.QuizAnswers.FIRST_QUESTION_ANSWER;
import static com.example.android.californiaquiz.QuizAnswers.FOURTH_QUESTION_ANSWER;
import static com.example.android.californiaquiz.QuizAnswers.SECOND_QUESTION_ANSWER;
import static com.example.android.californiaquiz.QuizAnswers.SIXTH_QUESTION_RIGHT_OPTION;
import static com.example.android.californiaquiz.QuizAnswers.THIRD_QUESTION_RIGHT_OPTION;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

  private static final String CURRENT_SCORE_KEY = "current_score_key";
  private int currentScore;

  private CheckBox q1Option1Checkbox;
  private CheckBox q1Option2Checkbox;
  private CheckBox q1Option3Checkbox;
  private CheckBox q1Option4Checkbox;
  private EditText q2EditText;
  private RadioGroup q3RadioGroup;
  private CheckBox q4Option1Checkbox;
  private CheckBox q4Option2Checkbox;
  private CheckBox q4Option3Checkbox;
  private CheckBox q4Option4Checkbox;
  private RadioGroup q5RadioGroup;
  private RadioGroup q6RadioGroup;
  private TextView currentScoreTextView;

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.putInt(CURRENT_SCORE_KEY, currentScore);
    super.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    if (savedInstanceState != null) {
      currentScore = savedInstanceState.getInt(CURRENT_SCORE_KEY);
      displayCurrentScore();
    }
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    q1Option1Checkbox = findViewById(R.id.quiz_q1_opt1);
    q1Option2Checkbox = findViewById(R.id.quiz_q1_opt2);
    q1Option3Checkbox = findViewById(R.id.quiz_q1_opt3);
    q1Option4Checkbox = findViewById(R.id.quiz_q1_opt4);
    q2EditText = findViewById(R.id.quiz_q2_input);
    q3RadioGroup = findViewById(R.id.quiz_q3_radio_group);
    q4Option1Checkbox = findViewById(R.id.quiz_q4_opt1);
    q4Option2Checkbox = findViewById(R.id.quiz_q4_opt2);
    q4Option3Checkbox = findViewById(R.id.quiz_q4_opt3);
    q4Option4Checkbox = findViewById(R.id.quiz_q4_opt4);
    q5RadioGroup = findViewById(R.id.quiz_q5_radio_group);
    q6RadioGroup = findViewById(R.id.quiz_q6_radio_group);
    currentScoreTextView = findViewById(R.id.points);
  }

  /**
   * Calculates user's score and shows it.
   */
  public void onResultButtonClick(View view) {
    ArrayList<Boolean> results = new ArrayList<>();
    results.add(Arrays.asList(
            q1Option1Checkbox.isChecked(),
            q1Option2Checkbox.isChecked(),
            q1Option3Checkbox.isChecked(),
            q1Option4Checkbox.isChecked())
        .equals(FIRST_QUESTION_ANSWER));
    results.add(q2EditText.getText().toString().equalsIgnoreCase(SECOND_QUESTION_ANSWER));
    results.add(q3RadioGroup.indexOfChild(findViewById(q3RadioGroup.getCheckedRadioButtonId()))
        == THIRD_QUESTION_RIGHT_OPTION);
    results.add(Arrays.asList(
            q4Option1Checkbox.isChecked(),
            q4Option2Checkbox.isChecked(),
            q4Option3Checkbox.isChecked(),
            q4Option4Checkbox.isChecked())
        .equals(FOURTH_QUESTION_ANSWER));
    results.add(q5RadioGroup.indexOfChild(findViewById(q5RadioGroup.getCheckedRadioButtonId()))
        == FIFTH_QUESTION_RIGHT_OPTION);
    results.add(q6RadioGroup.indexOfChild(findViewById(q6RadioGroup.getCheckedRadioButtonId()))
        == SIXTH_QUESTION_RIGHT_OPTION);

    int correctAnswersCount = 0;
    for (boolean answer : results) {
      if (answer) {
        correctAnswersCount++;
      }
    }
    currentScore = correctAnswersCount;
    displayCurrentScore();
  }

  /**
   * For each choice in question 3 the user will see toast messages that are trying to confuse
   * him/her.
   */
  public void onThirdAnswerClick(View view) {
    boolean isChecked = ((RadioButton) view).isChecked();
    switch (view.getId()) {
      case R.id.q3answer1:
        if (isChecked) {
          Toast.makeText(this, "Are you sure?", LENGTH_SHORT).show();
        }
        break;
      case R.id.q3answer2:
        if (isChecked) {
          Toast.makeText(this, "Want to change your mind?", LENGTH_SHORT).show();
        }
        break;
      case R.id.q3answer3:
        if (isChecked) {
          Toast.makeText(this, "Think twice.", LENGTH_SHORT).show();
        }
        break;
      case R.id.q3answer4:
        if (isChecked) {
          Toast.makeText(this, "Sure?", LENGTH_SHORT).show();
        }
        break;
      default:
        throw new RuntimeException("Unknown answer ID");
    }
  }

  /**
   * For each choice in question 5 the user will see toast messages that are trying to confuse
   * him/her.
   */
  public void onFifthAnswerClick(View view) {
    boolean isChecked = ((RadioButton) view).isChecked();
    switch (view.getId()) {
      case R.id.q5answer1:
        if (isChecked) {
          Toast.makeText(this, "Is this your final decision?", LENGTH_SHORT).show();
        }
        break;
      case R.id.q5answer2:
        if (isChecked) {
          Toast.makeText(this, "You still can change your mind.", LENGTH_SHORT).show();
        }
        break;
      case R.id.q5answer3:
        if (isChecked) {
          Toast.makeText(this, "Are you sure?", LENGTH_SHORT).show();
        }
        break;
    }
  }

  /**
   * For each choice in question 6 the user will see toast messages that are trying to confuse
   * him/her.
   */
  public void onSixthAnswerClick(View view) {
    boolean isChecked = ((RadioButton) view).isChecked();
    switch (view.getId()) {
      case R.id.q6answer1:
        if (isChecked) {
          Toast.makeText(this, "Dates are so confusing!", LENGTH_SHORT).show();
        }
        break;
      case R.id.q6answer2:
        if (isChecked) {
          Toast.makeText(this, "Maybe it was in 1948?", LENGTH_SHORT).show();
        }
        break;
      case R.id.q6answer3:
        if (isChecked) {
          Toast.makeText(this, "These numbers look so similar.", LENGTH_SHORT).show();
        }
        break;
      case R.id.q6answer4:
        if (isChecked) {
          Toast.makeText(this, "Last chance to change your mind.", LENGTH_SHORT).show();
        }
    }
  }

  /**
   * The method displays the total score on the screen.
   */
  private void displayCurrentScore() {
    if (currentScore == 6) {
      currentScoreTextView
          .setText(String.format(Locale.US,
              "%d points.", currentScore));
      Toast.makeText(this,
          "Congratulations! You answered all questions correctly.",
          Toast.LENGTH_LONG).show();
    } else {
      currentScoreTextView.setText(String.format(Locale.US, "%d points.", currentScore));
      Toast.makeText(this,
          (String.format(Locale.US, "You scored %d points.", currentScore)),
          Toast.LENGTH_LONG).show();
    }
  }

  /**
   * The methods sets the PointsCount to zero.
   */
  public void onResetButtonClick(View view) {
    currentScore = 0;

    q1Option1Checkbox.setChecked(false);
    q1Option2Checkbox.setChecked(false);
    q1Option3Checkbox.setChecked(false);
    q1Option4Checkbox.setChecked(false);
    q2EditText.setText("");
    q3RadioGroup.clearCheck();
    q4Option1Checkbox.setChecked(false);
    q4Option2Checkbox.setChecked(false);
    q4Option3Checkbox.setChecked(false);
    q4Option4Checkbox.setChecked(false);
    q5RadioGroup.clearCheck();
    q6RadioGroup.clearCheck();
    currentScoreTextView.setText("");
  }
}