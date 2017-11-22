package mvpframework.bwie.com.qqlogindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;


import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 登录
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv:

                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
//             UMShareAPI.get(MainActivity.this).doOauthVerify(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
        }

    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            String temp = "";
            for (String key : data.keySet()) {
                temp = temp + key + " : " + data.get(key) + "\n";
            }
            String s = temp.toString();


            Log.e("MainActivity", s);
            Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
