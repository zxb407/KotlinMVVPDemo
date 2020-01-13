package com.huantansheng.easyphotos.ui;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;
import com.huantansheng.easyphotos.setting.Setting;

import java.util.Locale;

class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        Configuration configuration = newBase.getResources().getConfiguration();
        Locale locale = new Locale(Setting.language);
        Locale.setDefault(locale);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            newBase = newBase.createConfigurationContext(configuration);
        } else {
            newBase.getResources().updateConfiguration(configuration, newBase.getResources().getDisplayMetrics());
        }
        super.attachBaseContext(new ContextWrapper(newBase));
    }
}
