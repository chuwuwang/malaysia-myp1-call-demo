package com.myp1.call;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LocalSearchActivity extends BaseActivity {

    private EditText mEditVoucher;
    private EditText mEditTransId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_search);
        initView();
    }

    private void initView() {
        mEditVoucher = findViewById(R.id.edit_input_voucher);
        mEditTransId = findViewById(R.id.edit_input_trans_id);
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String packageName = getPackageName();
        String outOrderNo = mEditTransId.getText().toString();
        String oriVoucherNo = mEditVoucher.getText().toString();

        Intent intent = new Intent(CALL_EXTRA_ACTION);
        intent.putExtra("requestType", "LOCAL_SEARCH");
        intent.putExtra("outOrderNo", outOrderNo);
        intent.putExtra("packageName", packageName);

        intent.putExtra("oriVouNo", oriVoucherNo);
        startActivity(intent);
    }

}