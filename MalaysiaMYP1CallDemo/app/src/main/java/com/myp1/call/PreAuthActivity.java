package com.myp1.call;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PreAuthActivity extends BaseActivity {

    private EditText mEditAmount;
    private EditText mEditTransId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_auth);
        initView();
    }

    private void initView() {
        mEditAmount = findViewById(R.id.edit_input_amount);
        mEditTransId = findViewById(R.id.edit_input_trans_id);
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String packageName = getPackageName();
        String outOrderNo = mEditTransId.getText().toString();

        Intent intent = new Intent(CALL_EXTRA_ACTION);
        intent.putExtra("requestType", "PRE_AUTH");
        intent.putExtra("outOrderNo", outOrderNo);
        intent.putExtra("packageName", packageName);

        try {
            String amount = mEditAmount.getText().toString();
            long value = Long.parseLong(amount);
            intent.putExtra("amount", value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }

}