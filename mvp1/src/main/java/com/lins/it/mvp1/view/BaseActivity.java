package com.lins.it.mvp1.view;

import android.app.AppComponentFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lins.it.mvp1.presenter.BasePresenter;

public abstract class BaseActivity<T extends BasePresenter,V extends IGirlView> extends AppCompatActivity {
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V)this);
    }

    protected abstract T createPresenter() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
