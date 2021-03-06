package com.duke.android.test38criminalintent;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//创建单例
public class CrimeLab {

    private static CrimeLab sCrimeLab =null;
    //s前缀代表静态变量
    private List<Crime> mCrimes;

    public static CrimeLab getInstance(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime #"+i);
            crime.setmSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime :mCrimes){
            if (crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
