package com.timmy008.studyjams2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.snappingstepper.SnappingStepper;

public class MainActivity extends AppCompatActivity {
    private SnappingStepper mSs;
    private EditText mEditText;
    private TextView mTvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mSs = (SnappingStepper) findViewById(R.id.ss);
        mEditText = (EditText) findViewById(R.id.editText);

        mTvTotal = (TextView) findViewById(R.id.tv_total);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = mSs.getValue();
                Editable price = mEditText.getText();
                double total = price.length() <= 0 ? 0 : calculatePrice(Double.parseDouble(price.toString()), value);
                String string = getString(R.string.total, total);
                Log.e("aa", string);
                mTvTotal.setText(string);
            }
        });
    }

    /**
     * 计算总价格
     *
     * @param price
     * @param value
     */
    private double calculatePrice(double price, int value) {
        return price * value;
    }
}
