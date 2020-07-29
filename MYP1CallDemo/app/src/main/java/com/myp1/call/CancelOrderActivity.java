package com.myp1.call;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class CancelOrderActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_order);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String packageName = getPackageName();

        Intent intent = new Intent(CALL_EXTRA_ACTION);
        intent.putExtra("requestType", "CANCEL_ORDER");
        intent.putExtra("packageName", packageName);
        startActivity(intent);
    }

}