package com.gxd.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gxd.demo.adapter.TestAdapter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.haowen.soulplanet.SampleItemBean;
import me.haowen.soulplanet.view.PlanetView;
import me.haowen.soulplanet.view.SoulPlanetsView;

/**
 * @author 86173
 * @version 1.0
 * @title
 * @description
 * @Package com.gxd.demo
 * @Date 2023/8/1 10:04
 */
public class MainFragment extends Fragment {

    private View root;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final List<SampleItemBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            SampleItemBean bean = new SampleItemBean();
            bean.setId(String.valueOf(i));
            bean.setName(getRandomNick());
            if (i % 12 == 0) {
                bean.setDesc("最匹配");
                bean.setPercent("95");
                bean.setColor(PlanetView.COLOR_BEST_MATCH);
            } else if (i % 20 == 0) {
                bean.setDesc("匹配");
                bean.setPercent("90");
                bean.setColor(PlanetView.COLOR_FEMALE);
            } else if (i % 33 == 0) {
                bean.setDesc("最新人");
                bean.setPercent("80");
                bean.setColor(PlanetView.COLOR_MOST_NEW);
            } else if (i % 18 == 0) {
                bean.setDesc("最闪耀");
                bean.setPercent("80");
                bean.setColor(PlanetView.COLOR_MALE);
                bean.setHasShadow(true);
            } else {
                bean.setDesc("描述");
                bean.setPercent("60");
                bean.setColor(PlanetView.COLOR_MOST_ACTIVE);
            }
            list.add(bean);
        }

        final SoulPlanetsView soulPlanet = root.findViewById(R.id.soulPlanetView);
        soulPlanet.setData(list);
        soulPlanet.setAdapter(new TestAdapter(list));

        root.findViewById(R.id.clBackground).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "数据更新中", Toast.LENGTH_SHORT).show();
                soulPlanet.setAdapter(new TestAdapter(list));
            }
        });


        soulPlanet.setOnTagClickListener(new SoulPlanetsView.OnTagClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, SampleItemBean bean) {
                Toast.makeText(getContext(), bean.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getRandomNick() {
        Random random = new Random();
        int len = random.nextInt(12) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(getRandomSingleCharacter());
        }
        return builder.toString();
    }

    private String getRandomSingleCharacter() {
        String str = "";
        int heightPos;
        int lowPos;
        Random rd = new Random();
        heightPos = 176 + Math.abs(rd.nextInt(39));
        lowPos = 161 + Math.abs(rd.nextInt(93));
        byte[] bt = new byte[2];
        bt[0] = Integer.valueOf(heightPos).byteValue();
        bt[1] = Integer.valueOf(lowPos).byteValue();
        try {
            str = new String(bt, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
