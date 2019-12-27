package com.jjshouse.kotlinmvvpdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.crashlytics.android.Crashlytics

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    public fun forceCrash(view: View) {
        Crashlytics.getInstance().crash()
//        Thread(Runnable { Crashlytics.getInstance().crash() }).start()
    }
}
