package com.example.android_fundamentals_2020.week3;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_fundamentals_2020.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mSpinnerAndroid;
    private List<String> mDataSourceSpinner;
    private ArrayAdapter<String> mAdapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        mSpinnerAndroid = findViewById(R.id.spinner); //getting the instance of spinner
        mSpinnerAndroid.setOnItemSelectedListener(this);

        mDataSourceSpinner = getSource();
        mAdapterSpinner = getAdapter();
        mAdapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerAndroid.setAdapter(mAdapterSpinner);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        List<String> androids = getSource();
        Toast.makeText(getApplicationContext(), androids.get(i), Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}


    private List<String> getSource() {
        List<String> androids = new ArrayList<String>();
        androids.add("Cupcake");
        androids.add("Donut");
        androids.add("Eclair");
        androids.add("KitKat");
        androids.add("Pie");
        return androids;
    }

    private ArrayAdapter<String> getAdapter() {
        return new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mDataSourceSpinner);
    }

}
