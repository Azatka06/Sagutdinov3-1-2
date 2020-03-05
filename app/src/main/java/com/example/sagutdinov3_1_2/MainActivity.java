package com.example.sagutdinov3_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sagutdinov3_1_2.R;

public class MainActivity extends AppCompatActivity {

    TextView outputText;

    Button butC, butPlusMinus, butProc, butDiv, butMul, butPlus, butMinus, butEq, butPoint;
    String selected = "";
    double data;
    final String PLUS = "plus";
    final String MINUS = "minus";
    final String PROCENT = "procent";
    final String MUL = "multiplex";
    final String DIV = "div";

    private void initViews() {

        outputText = findViewById(R.id.outputText);
        butC = findViewById(R.id.butC);
        butPlus = findViewById(R.id.butPlus);
        butMinus = findViewById(R.id.butMinus);
        butMul = findViewById(R.id.butMul);
        butDiv = findViewById(R.id.butDiv);
        butEq = findViewById(R.id.butEq);
        butProc = findViewById(R.id.butProc);
        butPlusMinus = findViewById(R.id.butPlusMinus);
        butPoint = findViewById(R.id.butPoint);

        butPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputText.setText(String.valueOf((
                        -1 * Double.valueOf(outputText.getText().toString()))));
            }
        });

        butPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                selected = PLUS;
            }
        });

        butMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                selected = MINUS;
            }
        });

        butProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                selected = PROCENT;
            }
        });

        butMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                selected = MUL;
            }
        });

        butDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                selected = DIV;
            }
        });

        butEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selected.equals("")) {
                    double dataEq = Double.valueOf(outputText.getText().toString());
                    switch (selected) {
                        case PLUS: {
                            outputText.setText(String.valueOf(data + dataEq));
                            break;
                        }
                        case MINUS: {
                            outputText.setText(String.valueOf(data - dataEq));
                            break;
                        }
                        case PROCENT: {
                            outputText.setText(String.valueOf(data / 100 * dataEq));
                            break;
                        }
                        case MUL: {
                            outputText.setText(String.valueOf(data * dataEq));
                            break;
                        }
                        case DIV: {
                            if (dataEq == 0) {
                                Toast.makeText(MainActivity.this,
                                        "Ошибка, 0", Toast.LENGTH_LONG).show();
                            } else {
                                outputText.setText(String.valueOf(data / dataEq));
                            }
                            break;
                        }
                    }
                }
            }
        });
        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = "";
                outputText.setText("");
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    public void btnPress(View view) {
        String output = outputText.getText().toString();
        Button btn = (Button) view;
        if (output.contains(".") && (btn.getId() == R.id.butPoint)) { //проверяем, нет ли знака запятой в строке output
            Toast.makeText(MainActivity.this, "Ошибка, число уже не целое", Toast.LENGTH_LONG).show();
        } else {
            if ((output.trim().length()==0) && (btn.getId() == R.id.butPoint)) {
                Toast.makeText(MainActivity.this, "Ошибка, вы не ввели ни одну цифру", Toast.LENGTH_LONG).show();
            } else {
                outputText.append(btn.getText());
            }

        }


    }
}
