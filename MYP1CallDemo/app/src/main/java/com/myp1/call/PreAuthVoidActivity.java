package com.myp1.call;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PreAuthVoidActivity extends BaseActivity {

    private EditText mEditAmount;
    private EditText mEditTransId;
    private EditText mEditTime;
    private EditText mEditDate;
    private EditText mEditAuth;
    private EditText mEditVoucher;
    private EditText mEditReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_auth_void);
        initView();
    }

    private void initView() {
        mEditAmount = findViewById(R.id.edit_input_amount);
        mEditTransId = findViewById(R.id.edit_input_trans_id);

        mEditTime = findViewById(R.id.edit_input_time);
        mEditDate = findViewById(R.id.edit_input_date);
        mEditAuth = findViewById(R.id.edit_input_auth);
        mEditVoucher = findViewById(R.id.edit_input_voucher);
        mEditReference = findViewById(R.id.edit_input_reference);

        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String packageName = getPackageName();
        String outOrderNo = mEditTransId.getText().toString();

        String oriTime = mEditTime.getText().toString();
        String oriDate = mEditDate.getText().toString();
        String oriAuthNo = mEditAuth.getText().toString();
        String oriVouNo = mEditVoucher.getText().toString();
        String oriRefNo = mEditReference.getText().toString();

        Intent intent = new Intent(CALL_EXTRA_ACTION);
        intent.putExtra("requestType", "PRE_AUTH_VOID");
        intent.putExtra("outOrderNo", outOrderNo);
        intent.putExtra("packageName", packageName);

        intent.putExtra("oriTime", oriTime);
        intent.putExtra("oriDate", oriDate);
        intent.putExtra("oriVouNo", oriVouNo);
        intent.putExtra("oriRefNo", oriRefNo);
        intent.putExtra("oriAuthNo", oriAuthNo);

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