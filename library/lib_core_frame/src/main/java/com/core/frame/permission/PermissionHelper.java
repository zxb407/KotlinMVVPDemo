package com.core.frame.permission;/**
 * Created by Administrator on 2018/9/11.
 *
 * @version $Rev$
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

/**
 * <b>Project:</b> AutoGroup<br>
 * <b>Create Date:</b> 2018/9/11 13:56<br>
 * <b>Author:</b> Zhangxubo<br>
 * <b>Description:</b>
 * 动态权限帮助类
 * <br>
 */
public class PermissionHelper {
    private Activity mActivity;
    private PermissionInterface mPermissionInterface;
    private int permissionCode = -1;
    private AlertDialog mDialog;

    public PermissionHelper(@NonNull Activity activity, @NonNull PermissionInterface permissionInterface) {
        mActivity = activity;
        mPermissionInterface = permissionInterface;
    }

    public boolean hasPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mActivity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public void requestPermission(final String permission, final int requestCode) {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(mActivity, permission)) {
            // 拒绝选了"不再提醒"，一般提示跳转到权限设置页面
            AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
            builder.setTitle("permission")
                    .setMessage("点击允许才可以使用我们的app哦")
                    .setPositiveButton("去允许", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (mDialog != null && mDialog.isShowing()) {
                                mDialog.dismiss();
                            }
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", mActivity.getPackageName(), null);//注意就是"package",不用改成自己的包名
                            intent.setData(uri);
                            mActivity.startActivityForResult(intent, requestCode);
                        }
                    });
            mDialog = builder.create();
            mDialog.setCanceledOnTouchOutside(false);
            mDialog.show();
        } else {
            PermissionUtil.requestPermissions(mActivity, new String[]{permission}, requestCode);
        }
    }

    /**
     * 开始请求权限。
     * 方法内部已经对Android M 或以上版本进行了判断，外部使用不再需要重复判断。
     * 如果设备还不是M或以上版本，则也会回调到requestPermissionsSuccess方法。
     */
    public void requestPermissions() {
        String[] deniedPermissions = PermissionUtil.getDeniedPermissions(mActivity, mPermissionInterface.getPermissions());
        if (deniedPermissions != null && deniedPermissions.length > 0) {
            PermissionUtil.requestPermissions(mActivity, deniedPermissions, mPermissionInterface.getPermissionsRequestCode());
        } else {
            mPermissionInterface.requestPermissionsSuccess();
        }
    }

    /**
     * 在Activity中的onRequestPermissionsResult中调用
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     * @return true 代表对该requestCode感兴趣，并已经处理掉了。false 对该requestCode不感兴趣，不处理。
     */
    public boolean requestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean isAllGranted = true;//是否全部权限已授权
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                isAllGranted = false;
                break;
            }
        }
        if (isAllGranted) {
            //已全部授权
            if (requestCode == mPermissionInterface.getPermissionsRequestCode()) {
                mPermissionInterface.requestPermissionsSuccess();
                return true;
            } else if (requestCode == permissionCode) {
                mPermissionInterface.requestPermissionSuccess(permissions);
                return true;
            }
        } else {
            //权限有缺失
            if (requestCode == mPermissionInterface.getPermissionsRequestCode()) {
                mPermissionInterface.requestPermissionsFail();
                return true;
            } else if (requestCode == permissionCode) {
                mPermissionInterface.requestPermissionFail(permissions);
                return true;
            }
        }
        return false;
    }
}
