package com.basekit.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.basekit.util.AppManager;
import com.basekit.util.ToastUtils;

public abstract class BaseActivity extends AppCompatActivity {

    private BaseActivity mCurActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
        AppManager.getInstance().add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCurActivity = AppManager.getInstance().getCurrent();
    }

    @Override
    protected void onDestroy() {
        AppManager.getInstance().remove(this);
        super.onDestroy();
    }

    public abstract void initView();

    public void initData() {
    }

    public void initListener() {
    }

    /**
     * 显示短Toast
     * @param text
     */
    public void showShortToast(String text){
        ToastUtils.showShortToast(this,text);
    }

    /**
     * 显示长Toast
     * @param text
     */
    public void showLongToast(String text){
        ToastUtils.showLongToast(this, text);
    }

    /**
     * 完全退出
     */
    protected void exit(){
        AppManager.getInstance().removeAll();
    }

    /**
     * 关闭当前activity
     */
    public void finishCurrent(){
        AppManager.getInstance().removeCurrent();
    }


}
