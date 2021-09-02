package com.example.dynamicviewexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    LinearLayout linearLayout;
    Button buttonAdd;
    Button buttonSubmit;

    ArrayList<Cricketer> cricketerArrayList = new ArrayList<>();



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
                Toast.makeText(this, "Please Select at least one", Toast.LENGTH_SHORT).show();
            }
        });

        addView();

    }

    private boolean checkIfValidAndRead() {
        cricketerArrayList.clear();
        boolean result = true;

        for (int i = 0;i<linearLayout.getChildCount();i++){

            View cricketView = linearLayout.getChildAt(i);

            EditText editText = (EditText) cricketView.findViewById(R.id.edtName);

            Cricketer  cricketer = new Cricketer();

            if (!editText.getText().toString().equals("")){
                cricketer.setName(editText.getText().toString());
            }else {
                return false;

            }

            cricketerArrayList.add(cricketer);

            if (cricketerArrayList.size()==0){
                result = false;
                Toast.makeText(this, "Please Select at least one", Toast.LENGTH_SHORT).show();
            }else if (!result){
                Toast.makeText(this, "Enter All", Toast.LENGTH_SHORT).show();
            }

        }

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