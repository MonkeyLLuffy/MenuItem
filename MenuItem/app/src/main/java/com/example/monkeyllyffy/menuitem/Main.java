package com.example.monkeyllyffy.menuitem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.Toast;


/**
 * Created by Administrator on 2015/11/5 0005.
 */
public class Main extends Activity implements View.OnKeyListener,AdapterView.OnItemClickListener{

    private PopupWindow popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridView gridView = (GridView)getLayoutInflater().inflate(R.layout.popup_window,null);
        GridAdapter adapter = new GridAdapter(this);
        gridView.setAdapter(adapter);
        gridView.setOnKeyListener(this);
        gridView.setOnItemClickListener(this);
        popup = new PopupWindow(gridView, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        popup.setFocusable(true);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        //显示对话框，如果点击确定，关闭弹出框，并显示一条消息，点取消也是显示一条信息关闭弹出框
        new AlertDialog.Builder(this).setIcon(R.drawable.icon).setTitle("是否打开?").setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Main.this,"您取消了打开"+Const.GRID_ITEM_TEXT_LIST[position],Toast.LENGTH_LONG).show();
            }
        }).setPositiveButton(
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        popup.dismiss();
                        Toast.makeText(Main.this, Const.GRID_ITEM_TEXT_LIST[position], Toast.LENGTH_SHORT).show();
                    }
                }
        ).show();




    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK://�捕捉back键，如果窗口已显示，则关闭它
             if (popup.isShowing())
                        popup.dismiss();
                break;

        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //创建一项，否则系统不会调用OnMenuOpen方法
        menu.add("menu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {

        if (popup!=null){
            if (popup.isShowing()){
                //�如果窗口已显示，则关闭它
                 popup.dismiss();
            }
            else {
                View layout = getLayoutInflater().inflate(R.layout.activity_main,null);
                //�弹出它
                popup.showAtLocation(layout, Gravity.CENTER,0,0);
            }

        }
        return false;
    }
}
