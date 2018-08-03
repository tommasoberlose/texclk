package com.tommasoberlose.texclk.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.tommasoberlose.texclk.Constants;
import com.tommasoberlose.texclk.R;

import java.util.ArrayList;
import java.util.List;

public class GridRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private List<Integer> mWidgetItems = new ArrayList<>();
    private Context mContext;

    public GridRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        for (int i = 0; i < Constants.CHAR.length; i++)
            mWidgetItems.add(i);

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {
        mWidgetItems.clear();

    }

    @Override
    public int getCount() {
        return mWidgetItems.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {


        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.widget_item);
        rv.setTextViewText(R.id.text, Constants.CHAR[position]);
        // rv.setInt(R.id.text, "setAlpha", mWidgetItems.get(position) == 0 ? 30 : 100);

        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return new RemoteViews(mContext.getPackageName(), R.layout.loading_page);
    }



    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}