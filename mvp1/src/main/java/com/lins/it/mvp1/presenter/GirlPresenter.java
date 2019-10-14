package com.lins.it.mvp1.presenter;

import com.lins.it.mvp1.bean.Girl;
import com.lins.it.mvp1.model.GirlModel;
import com.lins.it.mvp1.model.IGirlModel;
import com.lins.it.mvp1.view.IGirlView;

import java.lang.ref.WeakReference;
import java.util.List;

public class GirlPresenter<T extends IGirlView>extends BasePresenter<T>{

    //IGirlView iGirlView;
    IGirlModel iGirlModel = new GirlModel();

//    public GirlPresenter(T view) {
//        this.iGirlView = new WeakReference<>(view);
//    }



    //执行UI逻辑
    public void fetch(){
        if(iGirlModel!= null && iGirlView != null){
            iGirlModel.loadGirlData(new IGirlModel.OnLoadListener() {
                @Override
                public void onComplete(List<Girl> list) {
                    iGirlView.get().showGirlView(list);
                }
            });
        }
    }
}
