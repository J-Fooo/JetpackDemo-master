package com.demo.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumViewModel extends ViewModel {
    private MutableLiveData<Integer> numData;
    private int num;
    public MutableLiveData<Integer> getNumData() {
        if (numData == null) {
            numData = new MutableLiveData<>();
        }
        return numData;
    }

    public void setNumData(int num) {
        numData.postValue(num);
        this.num = num;
    }
}
