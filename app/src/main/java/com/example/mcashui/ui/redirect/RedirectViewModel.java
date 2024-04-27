package com.example.mcashui.ui.redirect;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RedirectViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public RedirectViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Had to Add a Link to Redirect fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}