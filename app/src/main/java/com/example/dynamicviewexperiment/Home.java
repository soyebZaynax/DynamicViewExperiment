package com.example.dynamicviewexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout linearLayout;
    Button buttonAdd;
    Button buttonSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        linearLayout = findViewById(R.id.layoutList);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonAdd.setOnClickListener(view -> {
            addView();
        });

        buttonSubmit.setOnClickListener(view -> {
            if (checkIfValidAndRead()){

            }
        });

        addView();

    }

    private boolean checkIfValidAndRead() {

        boolean result = true;

        return result;

    }


    private void addView() {

        View cricketerView = getLayoutInflater().inflate(R.layout.row_add_cricketer,null,false);

        EditText editText = (EditText) cricketerView.findViewById(R.id.edtName);

        ImageView imageView = (ImageView) cricketerView.findViewById(R.id.imgClose);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(cricketerView);
            }
        });

        linearLayout.addView(cricketerView);

    }

    private void removeView(View view){
        linearLayout.removeView(view);
    }
}