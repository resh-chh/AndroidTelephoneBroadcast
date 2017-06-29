package com.xyz.telephonebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

public class ICR extends BroadcastReceiver {
    String msg="";

    public ICR() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            String state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if(TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
                String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                msg += incomingNumber + "\n" ;
            }
        }
        catch (Exception e) {

        }
        MainActivity.tvLog.setText(MainActivity.tvLog.getText() + msg);
    }
}
