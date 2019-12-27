package com.core.frame.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description: manage activity
 *
 */
public class BaseDialogFragment extends DialogFragment{

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AppCompatDialog(getActivity(), getTheme());
    }

    @Override
    public AppCompatDialog getDialog() {
        return (AppCompatDialog) super.getDialog();
    }

    public int show(FragmentTransaction transaction) {
        return super.show(transaction, getTagString());
    }

    public void show(FragmentManager manager) {
        super.show(manager, getTagString());
    }

    /**
     * Dismiss the fragment and its dialog.  If the fragment was added to the
     * back stack, all back stack state up to and including this entry will
     * be popped.  Otherwise, a new transaction will be committed to remove
     * the fragment.
     */
    @Override
    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    protected String getTagString() {
        return getClass().getSimpleName();
    }
}
