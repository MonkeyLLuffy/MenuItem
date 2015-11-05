package com.example.monkeyllyffy.menuitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/5 0005.
 */
public class GridAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public GridAdapter(Context context){
        mContext = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return Const.GRID_iTEM_iCON_ID_LIST.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.grid_item,null);
        //返回grid_item的页面的textView和ImageView
        ImageView ivGridItemIcon = (ImageView) convertView.findViewById(R.id.ivGridItemIcon);
        TextView tvGridItemText = (TextView) convertView.findViewById(R.id.ivGridItemText);

        ivGridItemIcon.setImageResource(Const.GRID_iTEM_iCON_ID_LIST[position]);
        //设置要显示的图像
        tvGridItemText.setText(Const.GRID_ITEM_TEXT_LIST[position]);
        //设置显示的文本

        return convertView;
    }
}
