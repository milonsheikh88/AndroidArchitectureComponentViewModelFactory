package com.milonsheikh.architecturecomponentviewmodelfactory;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainViewModel extends ViewModel{
    private int clickCountA=0, clickCountB = 0;

    public MainViewModel(int clickCountA, int clickCountB) {
        this.clickCountA = clickCountA;
        this.clickCountB = clickCountB;
    }

    public int getInitialCountA() {
        return clickCountA;
    }
    public int getInitialCountB() {
        return clickCountB;
    }

    public int getCurrentCountA() {
        clickCountA += 1;
        return clickCountA;
    }
    public int getCurrentCountB() {
        clickCountB += 1;
        return clickCountB;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        System.out.println( "=== ViewModel Destroyed ===");
    }

}
