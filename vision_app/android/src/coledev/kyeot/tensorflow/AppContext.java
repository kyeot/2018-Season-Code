package coledev.kyeot.tensorflow;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

import coledev.kyeot.tensorflow.comm.RobotConnection;

public class AppContext extends Application {

    private AppContext instance;
    private PowerManager.WakeLock wakeLock;


    // This class is mainly here so we can get references to the application context in places where
    // it is otherwise extremely hairy to do so. USE SPARINGLY.
    private static AppContext app;

    private RobotConnection rc;

    public AppContext() {
        super();
        app = this;
    }


    public static Context getDefaultContext() {
        return app.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        rc = new RobotConnection(getDefaultContext());
        rc.start();
    }

    public static RobotConnection getRobotConnection() {
        return app.rc;
    }



    public PowerManager.WakeLock getWakeLock() {
        if(wakeLock == null) {
            // lazy loading: first call, create wakeLock via PowerManager.
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "wakeup");
        }
        return wakeLock;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        rc.stop();
    }
}