package dev.joven.secondlib;

import android.app.Application;
import android.content.Context;

import com.mgd.mgddevtools.mgdUtil;

public class GlblConf extends Application {
    public static mgdUtil tools;
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        this.context = getBaseContext();

        tools = new mgdUtil(this);
    }
    public static mgdUtil getTools(Context context)
    {
        if (tools == null)
            tools  = new mgdUtil(context);
        return tools;
    }
}
