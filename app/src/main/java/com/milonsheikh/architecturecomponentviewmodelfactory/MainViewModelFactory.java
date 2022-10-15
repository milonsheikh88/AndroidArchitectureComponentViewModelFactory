package com.milonsheikh.architecturecomponentviewmodelfactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private int clickCountA=0, clickCountB = 0;

    public MainViewModelFactory(int clickCountA, int clickCountB) {
        this.clickCountA = clickCountA;
        this.clickCountB = clickCountB;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(clickCountA,clickCountB);
        }
        throw new IllegalArgumentException("=== Unknown ViewModel class ===");
    }
}
