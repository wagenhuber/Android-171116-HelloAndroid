package com.example.wagenhuberg.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView tvNachricht;
    private Button btnWeiterFertig;
    private EditText etEingabe;
    private Boolean ersterKlick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNachricht = findViewById(R.id.tv_nachricht);
        btnWeiterFertig = findViewById(R.id.btn_weiter_fertig);
        etEingabe = findViewById(R.id.et_eingabe);

        tvNachricht.setText(R.string.willkommen);
        btnWeiterFertig.setText(R.string.weiter);
        btnWeiterFertig.setEnabled(false);
        ersterKlick = true;

        btnWeiterFertig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ersterKlick) {

                    tvNachricht.setText(getString(R.string.hallo, etEingabe.getText()));
                    etEingabe.setVisibility(View.INVISIBLE);
                    btnWeiterFertig.setText(R.string.fertig);
                    ersterKlick = false;
                } else {
                    finish();
                }
            }
        });


        etEingabe.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(btnWeiterFertig.isEnabled()){
                    btnWeiterFertig.performClick();
                }
                return true;
            }
        });




        etEingabe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void afterTextChanged(Editable editable) {
                btnWeiterFertig.setEnabled(editable.toString().contains(" "));

            }
        });
    }
}
