package com.lins.it.mvp1.presenter;

import com.lins.it.mvp1.view.IGirlView;

import java.lang.ref.WeakReference;

public class BasePresenter <T extends IGirlView> {
    WeakReference<T>iGirlView;
    public void attachView(T view ){
        iGirlView = new WeakReference<>(view);
    }

    public void detachView(){
        if(iGirlView != null){
            iGirlView.clear();
            iGirlView = null;
        }
    }
}
