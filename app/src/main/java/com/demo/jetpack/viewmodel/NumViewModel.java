package com.demo.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumViewModel extends ViewModel {
    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum() {
        if (num == null) {
            num = new MutableLiveData<>();
        }
        return num;
    }
}
