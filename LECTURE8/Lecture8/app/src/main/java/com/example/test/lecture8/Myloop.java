package com.example.test.lecture8;

import android.os.Handler;


public class Myloop  {

    private LoopDoneListener done;

    public void setOnLoopDoneListener(LoopDoneListener loopDoneListener)
    {
        done=loopDoneListener;

    }

    @SuppressWarnings("StatementWithEmptyBody")
    public  void doloop(Handler handler) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                done.onLoopDone();

            }
        };
        handler.postDelayed(r, 10000);
    }




    public   interface LoopDoneListener
    {
         void onLoopDone();

    }


}
