package com.lins.it.mvp1.model;

import com.lins.it.mvp1.R;
import com.lins.it.mvp1.bean.Girl;

import java.util.ArrayList;
import java.util.List;

public class GirlModel implements IGirlModel{
    List<Girl> list = new ArrayList<>();
    @Override
    public void loadGirlData(OnLoadListener listener) {
        list.add(new Girl(R.mipmap.ic_launcher,"123"));
        list.add(new Girl(R.mipmap.ic_launcher,"124"));
        list.add(new Girl(R.mipmap.ic_launcher,"125"));
        list.add(new Girl(R.mipmap.ic_launcher,"126"));
        list.add(new Girl(R.mipmap.ic_launcher,"127"));
        list.add(new Girl(R.mipmap.ic_launcher,"128"));
        list.add(new Girl(R.mipmap.ic_launcher,"129"));
        listener.onComplete(list);
    }
}
