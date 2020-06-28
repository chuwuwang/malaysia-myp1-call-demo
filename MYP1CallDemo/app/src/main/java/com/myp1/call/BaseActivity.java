package com.myp1.call;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String CALL_EXTRA_ACTION = "com.weak.payment.ACTION_PAY";

    @Override
    public void startActivity(Intent intent) {
        final PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo.size() > 0) {
            super.startActivity(intent);
        } else {
            Toast.makeText(this, "此机器上没有安装支付应用", Toast.LENGTH_SHORT).show();
        }
    }

    public void openActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

}