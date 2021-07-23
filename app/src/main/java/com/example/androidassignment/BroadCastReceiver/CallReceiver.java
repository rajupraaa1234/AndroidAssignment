package com.example.androidassignment.BroadCastReceiver;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class CallReceiver extends PhonecallReceiver{
    @Override
    protected void onIncomingCallReceived(Context ctx, String number, Date start)
    {
        Toast.makeText(ctx, "Calling from " + number, Toast.LENGTH_SHORT).show();
        Log.i("CallReceiver","onIncomingCallReceived");
        //
    }

    @Override
    protected void onIncomingCallAnswered(Context ctx, String number, Date start)
    {
        Toast.makeText(ctx, "onIncomingCallAnswered", Toast.LENGTH_SHORT).show();
        Log.i("CallReceiver","onIncomingCallAnswered");
        //
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end)
    {
        Toast.makeText(ctx, "onIncomingCallEnded", Toast.LENGTH_SHORT).show();
        Log.i("CallReceiver","onIncomingCallEnded");
        //
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start)
    {
        Toast.makeText(ctx, "onOutgoingCallStarted", Toast.LENGTH_SHORT).show();
        Log.i("CallReceiver","onOutgoingCallStarted");
        //
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end)
    {
        Toast.makeText(ctx, "onOutgoingCallEnded", Toast.LENGTH_SHORT).show();
        Log.i("CallReceiver","onOutgoingCallEnded");
        //
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start)
    {
        Toast.makeText(ctx, "onMissedCall", Toast.LENGTH_SHORT).show();
        Log.i("CallReceiver","onMissedCall");
        //
    }
}
