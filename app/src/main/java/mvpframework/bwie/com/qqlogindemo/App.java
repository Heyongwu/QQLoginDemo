package mvpframework.bwie.com.qqlogindemo;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by 何永武 on 2017/11/9.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        UMShareAPI.get(this);
    }
    {
        PlatformConfig.setQQZone("1106449273","");
    }
}
