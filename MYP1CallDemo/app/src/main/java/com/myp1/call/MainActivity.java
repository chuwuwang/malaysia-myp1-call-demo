package com.myp1.call;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_sale).setOnClickListener(this);
        findViewById(R.id.btn_revoke).setOnClickListener(this);
        findViewById(R.id.btn_settlement).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.btn_sale:
                openActivity(SaleActivity.class);
                break;
            case R.id.btn_revoke:
                openActivity(RevokeActivity.class);
                break;
            case R.id.btn_settlement:
                openActivity(SettlementActivity.class);
                break;
        }
    }


}
