package com.lins.it.mvp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lins.it.mvp1.adapter.GirlAdapter;
import com.lins.it.mvp1.bean.Girl;
import com.lins.it.mvp1.presenter.BasePresenter;
import com.lins.it.mvp1.presenter.GirlPresenter;
import com.lins.it.mvp1.view.BaseActivity;
import com.lins.it.mvp1.view.IGirlView;

import java.util.List;

public class MainActivity extends BaseActivity<GirlPresenter<IGirlView>,IGirlView> implements IGirlView {

    private RecyclerView recycler_view;
    private GirlAdapter girlAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        presenter.fetch();
    }

    @Override
    protected GirlPresenter<IGirlView> createPresenter() {
        return new GirlPresenter<>();
    }


    @Override
    public void showGirlView(List<Girl> list) {
        recycler_view.setAdapter(new GirlAdapter(list));
    }

}
