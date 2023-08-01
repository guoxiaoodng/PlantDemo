package com.gxd.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.haowen.soulplanet.SampleItemBean;
import me.haowen.soulplanet.adapter.PlanetAdapter;
import me.haowen.soulplanet.utils.SizeUtils;
import me.haowen.soulplanet.view.PlanetView;

public class TestAdapter extends PlanetAdapter {

    private final List<SampleItemBean> mList;

    public TestAdapter(List<SampleItemBean> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public View getView(Context context, int position, ViewGroup parent) {
        PlanetView planetView = new PlanetView(context);
        int starColor = position % 2 == 0 ? PlanetView.COLOR_FEMALE : PlanetView.COLOR_MALE;

        planetView.setSign(mList.get(position).getName());
        planetView.setStarColor(mList.get(position).getColor());
        planetView.setHasShadow(mList.get(position).isHasShadow());
        planetView.setMatch(mList.get(position).getPercent() + "%", mList.get(position).getDesc());

        if (mList.get(position).isHasShadow()) {
            planetView.setMatchColor(starColor);
        } else {
            planetView.setMatchColor(PlanetView.COLOR_MOST_ACTIVE);
        }
        int starWidth = SizeUtils.dp2px(context, 50.0f);
        int starHeight = SizeUtils.dp2px(context, 85.0f);
        int starPaddingTop = SizeUtils.dp2px(context, 20.0f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(starWidth, starHeight);
        planetView.setPadding(0, starPaddingTop, 0, 0);
        planetView.setLayoutParams(layoutParams);
        return planetView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getPopularity(int position) {
        return position % 10;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {

    }
}