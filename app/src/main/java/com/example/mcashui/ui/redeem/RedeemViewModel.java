package com.example.mcashui.ui.redeem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RedeemViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public RedeemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("No Redeem!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}