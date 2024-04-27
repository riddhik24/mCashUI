package com.example.mcashui.ui.helpAndSupport;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpAndSupportViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public HelpAndSupportViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Help And Support fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}