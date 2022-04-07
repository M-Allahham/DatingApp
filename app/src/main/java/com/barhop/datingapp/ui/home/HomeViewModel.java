package com.barhop.datingapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    public int myElo;
    public int otherElo;

    public MutableLiveData<String> mText;

    public HomeViewModel() {
        myElo = 1000; // Get information from database, probably SQL and updated with every swipe
        otherElo = 1000; // This is just
        mText = new MutableLiveData<>();
        mText.setValue(String.valueOf(myElo));
    }

    public LiveData<String> getText() {
        return mText;
    }
}