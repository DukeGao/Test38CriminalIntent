package com.duke.android.test38criminalintent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();
    //为了实例化新的fragment，新增了createFragment()抽象方法，
    // SingleFragmentActivity的子类会实现该方法，来返回由activity托管的fragment实例


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        //获取FragmentManager本身
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        //Fragment事务被用来添加、移除、附加、分离或替换fragment队列中的fragment

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
            //add方法是整个事务的核心
        }
    }
}
