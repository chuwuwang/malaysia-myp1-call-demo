package com.myp1.call;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class SettlementActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String packageName = getPackageName();

        Intent intent = new Intent(CALL_EXTRA_ACTION);
        intent.putExtra("requestType", "SETTLEMENT");
        intent.putExtra("packageName", packageName);

        intent = addUserCustomTicketContent(intent);

        startActivity(intent);
    }

}