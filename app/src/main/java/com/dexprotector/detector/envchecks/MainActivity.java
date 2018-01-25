package com.dexprotector.detector.envchecks;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends Activity {

    enum ENV_CHECK {
        ROOT(0), DEBUG(1), EMULATOR(2), XPOSED(3), CUSTOM_FIRMWARE (4), INTEGRITY (5), WIRELESS_SECURITY(6);

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
        tv.setText("DeviceId: " + Build.SERIAL + "\n" +
                "Root detection result: " + envChecks.get(ENV_CHECK.ROOT.getValue()) + "\n" +
                "Debug detection result: " + envChecks.get(ENV_CHECK.DEBUG.getValue()) + "\n" +
                "Emulator detection result: " + envChecks.get(ENV_CHECK.EMULATOR.getValue()) + "\n" +
                "Xposed detection result: " + envChecks.get(ENV_CHECK.XPOSED.getValue()) + "\n" +
                "Custom firmware detection result: " + envChecks.get(ENV_CHECK.CUSTOM_FIRMWARE.getValue()) + "\n" +
                "Integrity detection result: " + envChecks.get(ENV_CHECK.INTEGRITY.getValue()) + "\n" +
                "Wireless security check result: " + envChecks.get(ENV_CHECK.WIRELESS_SECURITY.getValue()) + "\n"); 
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

    public static void positiveXposedCheck(Object data) {
        System.out.println("positiveXposedCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.XPOSED.getValue());
    }

    public static void negativeXposedCheck(Object data) {
        System.out.println("negativeXposedCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.XPOSED.getValue());
    }

    public static void positiveCustomFirmwareCheck(Object data) {
        System.out.println("positiveCustomFirmwareCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.CUSTOM_FIRMWARE.getValue());
    }

    public static void negativeCustomFirmwareCheck(Object data) {
        System.out.println("negativeCustomFirmwareCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.CUSTOM_FIRMWARE.getValue());
    }

    public static void positiveIntegrityCheck(Object data) {
        System.out.println("positiveIntegrityCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.INTEGRITY.getValue());
    }

    public static void negativeIntegrityCheck(Object data) {
        System.out.println("negativeIntegrityCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.INTEGRITY.getValue());
    }

    public static void positiveWirelessSecurityCheck(Object data) {
        System.out.println("positiveWirelessSecurityCheck");
        System.out.println("data:" + data);
        envChecks.set(ENV_CHECK.WIRELESS_SECURITY.getValue());
    }

    public static void negativeWirelessSecurityCheck(Object data) {
        System.out.println("negativeWirelessSecurityCheck");
        System.out.println("data:" + data);
        envChecks.clear(ENV_CHECK.WIRELESS_SECURITY.getValue());
    }

}
