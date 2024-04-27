package com.example.mcashui.ui.privacyPolicy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrivacypolicyViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public PrivacypolicyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Privacy Policy fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}