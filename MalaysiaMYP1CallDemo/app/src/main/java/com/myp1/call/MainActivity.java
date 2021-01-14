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
        findViewById(R.id.btn_local_search).setOnClickListener(this);
        findViewById(R.id.btn_cancel_order).setOnClickListener(this);
        findViewById(R.id.btn_pre_auth).setOnClickListener(this);
        findViewById(R.id.btn_pre_auth_void).setOnClickListener(this);
        findViewById(R.id.btn_pre_auth_complete).setOnClickListener(this);
        findViewById(R.id.btn_pre_auth_complete_void).setOnClickListener(this);
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
            case R.id.btn_local_search:
                openActivity(LocalSearchActivity.class);
                break;
            case R.id.btn_cancel_order:
                openActivity(CancelOrderActivity.class);
                break;
            case R.id.btn_pre_auth:
                openActivity(PreAuthActivity.class);
                break;
            case R.id.btn_pre_auth_void:
                openActivity(PreAuthVoidActivity.class);
                break;
            case R.id.btn_pre_auth_complete:
                openActivity(PreAuthCompleteActivity.class);
                break;
            case R.id.btn_pre_auth_complete_void:
                openActivity(PreAuthCompleteVoidActivity.class);
                break;
        }
    }

}