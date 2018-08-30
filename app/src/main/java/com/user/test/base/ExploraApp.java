package com.user.test.base;

import android.app.Application;
import android.content.Context;

import com.heady.explora.BuildConfig;
import com.user.test.data.component.DaggerNetComponent;
import com.user.test.data.component.NetComponent;
import com.user.test.data.module.AppModule;
import com.user.test.data.module.NetModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by yashthakur on 26/08/18.
 */

public class ExploraApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://randomuser.me/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

}
