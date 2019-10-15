package com.lins.it.mvp1.model;

import android.util.Log;

import com.lins.it.isolation_processor.httpprocessor.HttpCallBack;
import com.lins.it.isolation_processor.httpprocessor.HttpHelper;
import com.lins.it.mvp1.R;
import com.lins.it.mvp1.bean.Girl;
import com.lins.it.mvp1.bean.ResponceData;

import java.util.ArrayList;
import java.util.HashMap;
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

        //测试隔离层代码
        String url="https://v.juhe.cn/historyWeather/citys";
        HashMap<String,Object> params=new HashMap<>();
        params.put("province_id","2");
        params.put("key","bb52107206585ab074f5e59a8c73875b");
        HttpHelper.getInstance().post(url, params, new HttpCallBack<ResponceData>() {
            @Override
            public void onSuccess(ResponceData responceData) {
                Log.i("jett",responceData.getResultcode());
            }
        });
    }
}
