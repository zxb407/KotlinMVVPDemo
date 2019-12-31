package com.core.frame.crash

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.core.frame.R
import com.core.frame.dialog.AlertDialogFragment

/**
 * PackageName: com.core.frame.crash
 * Created by xbzhang on 2019/12/27
 * Description:
 */
class CrashDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val alertDialogFragment = AlertDialogFragment()
        alertDialogFragment.setTitle(getString(R.string.crash_title))
        alertDialogFragment.setMessage(getString(R.string.crash_content))
        val listener = DialogInterface.OnClickListener { dialog, which -> finish() }
        alertDialogFragment.isCancelable = false
        alertDialogFragment.setPositiveButton(getString(R.string.bt_sure), listener)
        alertDialogFragment.setNegativeButton(getString(R.string.bt_cancel), listener)
        alertDialogFragment.show(supportFragmentManager)
    }

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, CrashDialogActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
