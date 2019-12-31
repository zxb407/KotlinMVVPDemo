package com.core.frame.permission;

/**
 * Created by Administrator on 2018/9/11.
 * 权限请求接口
 * @version $Rev$
 */

public interface PermissionInterface {
    /**
     * 可设置请求权限请求码
     */
    int getPermissionsRequestCode();

    /**
     * 设置需要请求的权限
     */
    String[] getPermissions();

    /**
     * 请求权限组成功回调
     */
    void requestPermissionsSuccess();

    /**
     * 请求权限组失败回调
     */
    void requestPermissionsFail();
    /**
     * 请求单一权限成功回调
     */
    void requestPermissionSuccess(String[] permissions);

    /**
     * 请求单一权限权限失败回调
     */
    void requestPermissionFail(String[] permissions);
}
