package com.myp1.call;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PreAuthCompleteVoidActivity extends BaseActivity {

    private EditText mEditTransId;
    private EditText mEditVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_auth_complete_void);
        initView();
    }

    private void initView() {
        mEditVoucher = findViewById(R.id.edit_input_voucher);
        mEditTransId = findViewById(R.id.edit_input_trans_id);

        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String packageName = getPackageName();
        String oriVouNo = mEditVoucher.getText().toString();
        String outOrderNo = mEditTransId.getText().toString();

        Intent intent = new Intent(CALL_EXTRA_ACTION);
        intent.putExtra("requestType", "PRE_AUTH_COMPLETE_VOID");
        intent.putExtra("outOrderNo", outOrderNo);
        intent.putExtra("packageName", packageName);

        intent.putExtra("oriVouNo", oriVouNo);
        startActivity(intent);
    }

}