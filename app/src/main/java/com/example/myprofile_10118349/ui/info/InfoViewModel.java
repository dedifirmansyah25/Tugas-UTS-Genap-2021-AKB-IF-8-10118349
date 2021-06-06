/*
07 JUNI 2021
10118349
Dedi firmansyah
IF8
*/

package com.example.myprofile_10118349.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InfoViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}