package com.example.mahe.lab7q1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView listView1;
    String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};
    //public static final String EXTRA_MESSAGE2 = "com.example.lab5q1.MESSAGE2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView1 =(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView1.setAdapter(adapter);
        // Register the ListView  for Context menu
        registerForContextMenu(listView1);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "sim/phone");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "call");
        menu.add(0, v.getId(), 0, "message");
        menu.add(0, v.getId(), 0, "whatapp/gmail");
    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="call"){
            //Intent intent = new Intent(this, call.class);
            String message2=item.toString();
            // intent.putExtra(EXTRA_MESSAGE2, message2);
            // startActivity(intent);
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="message"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="whatsapp/gmail"){
            Toast.makeText(getApplicationContext(),"saved in whatsapp/gmail mode",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="sim/phone"){
            Toast.makeText(getApplicationContext(),"saved to sim",Toast.LENGTH_LONG).show();
        }
        else{
            return false;
        }
        return true;
    }
}
