package com.example.mckenzieandrews.todolist20;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDo extends Activity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        lvItems =(ListView) findViewById(R.id.lvItems);
        items= new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        
        setupListViewListener();
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener(){
                @Override
            public boolean onItemLongClick(AdapterView<?> adapter,
                                           View item, int pos, long id){
                    items.remove(pos);
                    itemsAdapter.notifyDataSetChanged();
                    return true;

            }
        });
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
    }

}
