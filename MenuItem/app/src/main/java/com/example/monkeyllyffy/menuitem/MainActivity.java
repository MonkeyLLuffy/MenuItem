package com.example.monkeyllyffy.menuitem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements MenuItem.OnMenuItemClickListener{

    private Menu menu;
    private int menuItemId = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (menu == null){
            return super.onCreateOptionsMenu(menu);
        }
        this.menu = menu;
        for (int i=0;i<5;i++){
            int id = menuItemId++;
            MenuItem menuItem = menu.add(1, id, id, "菜单" + i);
            menuItem.setIcon(R.drawable.shoucang);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
