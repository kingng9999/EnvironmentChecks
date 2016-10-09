package com.dexprotector.detector.envchecks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends Activity {

    enum ENV_CHECK {
        ROOT(0), DEBUG(1), EMULATOR(2);

        private final int idx;

        ENV_CHECK(final int newIdx) {
            idx = newIdx;
        }

        public int getValue() {
            return idx;
        }
    }

    static BitSet envChecks = new BitSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.text);
        doProbe(this);
        tv.setText("Root detection result: " + envChecks.get(ENV_CHECK.ROOT.getValue()) + "\n" +
                "Debug detection result: " + envChecks.get(ENV_CHECK.DEBUG.getValue()) + "\n" +
                "Emulator detection result: " + envChecks.get(ENV_CHECK.EMULATOR.getValue()) + "\n");
    }

    public void doProbe(Context ctx) {
        System.out.println("doProbe" + ctx);
    }

    public static void positiveRootCheck(Object data) {
        System.out.println("positiveRootCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.ROOT.getValue());
    }

    public static void negativeRootCheck(Object data) {
        System.out.println("negativeRootCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.ROOT.getValue());
    }

    public static void positiveDebugCheck(Object data) {
        System.out.println("positiveDebugCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.DEBUG.getValue());
    }

    public static void negativeDebugCheck(Object data) {
        System.out.println("negativeDebugCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.DEBUG.getValue());
    }

    public static void positiveEmulatorCheck(Object data) {
        System.out.println("positiveEmulatorCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.EMULATOR.getValue());
    }

    public static void negativeEmulatorCheck(Object data) {
        System.out.println("negativeEmulatorCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.EMULATOR.getValue());
    }

}


