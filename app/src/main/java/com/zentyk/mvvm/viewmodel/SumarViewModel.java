package com.zentyk.mvvm.viewmodel;

import androidx.lifecycle.ViewModel;

public class SumarViewModel extends ViewModel {
    private int result;

    public int GetResult() {
        return result;
    }
    public void SetResult(int result) {
        this.result = result;
    }
}
