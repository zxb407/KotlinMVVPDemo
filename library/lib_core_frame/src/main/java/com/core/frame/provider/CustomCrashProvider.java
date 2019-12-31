package com.core.frame.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.core.frame.crash.CustomCrashHandler;

/**
 * PackageName: com.core.frame.provider
 * Created by xbzhang on 2019/12/27
 * Description:
 */
public class CustomCrashProvider extends ContentProvider {
    private Context mContext;

    @Override
    public boolean onCreate() {
        mContext = getContext();
        Thread.setDefaultUncaughtExceptionHandler(new CustomCrashHandler(mContext,Thread.getDefaultUncaughtExceptionHandler()));
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
