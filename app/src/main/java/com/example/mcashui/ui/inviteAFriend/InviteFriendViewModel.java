package com.example.mcashui.ui.inviteAFriend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InviteFriendViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public InviteFriendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Invite A Friend fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
