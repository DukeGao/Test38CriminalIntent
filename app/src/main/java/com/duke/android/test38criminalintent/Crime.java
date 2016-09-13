package com.duke.android.test38criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Boolean mSolved;

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public void setmSolved(Boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Boolean isSolved() {
        return mSolved;
    }

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();

    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmTitle() {

        return mTitle;
    }

    public UUID getmId() {
        return mId;
    }
}
