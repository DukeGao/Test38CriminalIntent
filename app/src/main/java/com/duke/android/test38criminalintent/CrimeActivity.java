package com.duke.android.test38criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

//    public static final String EXTRA_CRIME_ID = "com.duke.android.test38criminalintent.CrimeActivity";
    private static final String EXTRA_CRIME_ID = "com.duke.android.test38criminalintent.CrimeActivity";

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
//        return new CrimeFragment();
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
//
//        FragmentManager fm = getSupportFragmentManager();
//        //获取FragmentManager本身
//        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
//        //Fragment事务被用来添加、移除、附加、分离或替换fragment队列中的fragment
//        if (fragment == null) {
//            fragment = new CrimeFragment();
//            fm.beginTransaction()
//                    .add(R.id.fragment_container, fragment)
//                    .commit();
//            //add方法是整个事务的核心
//        }
//
//    }
}
