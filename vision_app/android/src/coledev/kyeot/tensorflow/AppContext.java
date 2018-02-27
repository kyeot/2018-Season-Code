package coledev.kyeot.tensorflow;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

import coledev.kyeot.tensorflow.comm.RobotConnection;

public class AppContext extends Application {

    private AppContext instance;
    private PowerManager.WakeLock wakeLock;
    private OnScreenOffReceiver onScreenOffReceiver;

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
        registerKioskModeScreenOffReceiver();
        whitelistLockTasks();
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

    private void whitelistLockTasks() {
        DevicePolicyManager manager =
                (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName componentName = VisionDeviceAdminReceiver.getComponentName(this);

        if (manager.isDeviceOwnerApp(getPackageName())) {
            manager.setLockTaskPackages(componentName, new String[]{getPackageName()});
        }
    }

    private void registerKioskModeScreenOffReceiver() {
        // register screen off receiver
        final IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        onScreenOffReceiver = new OnScreenOffReceiver();
        registerReceiver(onScreenOffReceiver, filter);
    }



    @Override
    public void onTerminate() {
        super.onTerminate();
        rc.stop();
    }
}