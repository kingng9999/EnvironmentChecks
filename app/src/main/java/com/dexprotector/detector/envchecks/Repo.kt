package com.dexprotector.detector.envchecks
import android.content.Context
import android.util.Log
import java.sql.DriverManager.println

class Repo{

    companion object{
        @JvmStatic
        fun doProbe(ctx: Context) {
            Log.d("doProbe","a")
        }

        @JvmStatic
        fun positiveRootCheck(data: Any?) {
            Log.d("positiveRootCheck","a")
        }
        @JvmStatic
        fun negativeRootCheck(data: Any?) {
            Log.d("negativeRootCheck","a")
        }

    }
}