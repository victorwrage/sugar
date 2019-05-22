/*
 * Copyright 2019 wobiancao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sugar.demo.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sugar.demo.R;
import com.sugar.demo.bean.gank.GirlsData;
import com.sugar.demo.ui.mvp.gank.GankContract;
import com.sugar.demo.ui.mvp.gank.GankPresenter;
import com.sugar.sugarlibrary.base.BaseActivity;
import com.sugar.sugarlibrary.base.presenter.anno.CreatePresenter;
import com.sugar.sugarlibrary.base.presenter.anno.PresenterVariable;

import java.util.List;

/**
 * @author wobiancao
 * @date 2019-05-21
 * desc :
 */
@CreatePresenter(presenter = GankPresenter.class)
public class GankActivity extends BaseActivity<GankPresenter> implements GankContract.IView {

    @PresenterVariable
    GankPresenter mPresenter;

    TextView mInfoView;

    @Override
    protected int getContentView() {
        return R.layout.gank_activity_list;
    }



    @Override
    public void init(Bundle savedInstanceState) {
        mInfoView = findViewById(R.id.tv_info);

    }

    @Override
    public void loadData() {
        mPresenter.getFuliDataRepository("10", "1");
    }

    @Override
    public void bindData(List<GirlsData> data) {
        String jsonStr = new Gson().toJson(data);
        mInfoView.setText(jsonStr);
    }
}
