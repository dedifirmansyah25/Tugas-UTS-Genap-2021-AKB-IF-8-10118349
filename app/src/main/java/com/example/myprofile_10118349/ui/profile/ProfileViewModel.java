/*
06 JUNI 2021
10118349
Dedi firmansyah
IF8
*/
package com.example.myprofile_10118349.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}