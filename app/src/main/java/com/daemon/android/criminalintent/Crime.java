package com.daemon.android.criminalintent;

import java.util.Date;
import java.util.UUID;

/**CriminalIntent's model layer
 * Created by Chang on 05/12/16.
 */
public class Crime {
    private UUID mId;  //UUID:universally unique identifier
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public Crime(){
        //Generate unique identifier
       // mId = UUID.randomUUID();
        //mDate = new Date();
        this(UUID.randomUUID());
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getPhotoFilename(){
        return "IMG_" + getId().toString() + ".jpg";
    }
}
