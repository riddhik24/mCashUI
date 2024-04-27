package com.example.mcashui.ui.bInvite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BInviteViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public BInviteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Invite a Friend Bottom Navigation fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    // TODO: Implement the ViewModel
}