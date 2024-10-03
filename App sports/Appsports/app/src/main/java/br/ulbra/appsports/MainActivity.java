package br.ulbra.appsports;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    EditText stepsInput;
    RadioGroup radioGroupStepSize;
    CheckBox checkBoxRunning;
    TextView textViewResult;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        stepsInput = findViewById(R.id.editPassos);
        radioGroupStepSize = findViewById(R.id.rdMedia);
        checkBoxRunning = findViewById(R.id.ckSim);
        textViewResult = findViewById(R.id.txtResult);
        buttonCalculate = findViewById(R.id.btnCalc);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDistance();
            }
        });
    }

    private void calculateDistance() {
        // Pegando o número de passos inserido
        int steps = Integer.parseInt(stepsInput.getText().toString());

        // Determinando o tamanho do passo
        double stepLength = 0.0;
        int selectedId = radioGroupStepSize.getCheckedRadioButtonId();

        if (selectedId == R.id.rdCurt) {
            stepLength = 0.5;
        } else if (selectedId == R.id.rdMed) {
            stepLength = 0.7;
        } else if (selectedId == R.id.rdLong) {
            stepLength = 1.0;
        }

        // Calculando a distância base
        double distance = steps * stepLength;

        // Verificando se estava correndo
        if (checkBoxRunning.isChecked()) {
            distance *= 1.1; // Aumenta em 10%
        }

        // Exibindo o resultado
        textViewResult.setText("Distância percorrida: " + String.format("%.2f", distance) + " metros");
    }
}