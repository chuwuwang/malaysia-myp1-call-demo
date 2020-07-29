package com.myp1.call;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "BaseActivity";

    public static final String CALL_EXTRA_ACTION = "com.weak.payment.ACTION_PAY";
    // public static final String CALL_EXTRA_ACTION = "com.weak.payment.ACTION_PAY_MOBILITY_ONE";

    @Override
    public void startActivity(Intent intent) {
        final PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo.size() > 0) {
            for (ResolveInfo info : resolveInfo) {
                ActivityInfo activityInfo = info.activityInfo;
                String resolvePackageName = info.resolvePackageName;
                Log.e(TAG, "=====================================================================");
                Log.e(TAG, "resolvePackageName: " + resolvePackageName);
                if (activityInfo != null) {
                    String packageName = activityInfo.packageName;
                    String parentActivityName = activityInfo.parentActivityName;
                    Log.e(TAG, "activityInfo packageName: " + packageName);
                    Log.e(TAG, "activityInfo parentActivityName: " + parentActivityName);
                    ApplicationInfo applicationInfo = activityInfo.applicationInfo;
                    if (applicationInfo != null) {
                        packageName = applicationInfo.packageName;
                        String className = applicationInfo.className;
                        Log.e(TAG, "activityInfo className: " + className);
                        Log.e(TAG, "applicationInfo packageName: " + packageName);
                    }
                }
                Log.e(TAG, "=====================================================================");
            }
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