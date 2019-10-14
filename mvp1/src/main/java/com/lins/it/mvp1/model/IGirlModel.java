package com.lins.it.mvp1.model;

import com.lins.it.mvp1.bean.Girl;

import java.util.List;

public interface IGirlModel {
    void loadGirlData(OnLoadListener listener);
    interface OnLoadListener{
        void onComplete(List<Girl> list);
    }
}
