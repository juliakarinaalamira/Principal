package com.example.producto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<DataInfo> listdata;
    private ImageView bigimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
    }

    private void loadComponents() {
        ListView list = findViewById(R.id.listview);
        bigimg = findViewById(R.id.bigimage);
        //GridView grid = findViewById(R.id.gridview);
        //Spinner spinner = findViewById(R.id.spinner3);
        listdata = new ArrayList<>();

        Integer[] images = new Integer[]{R.drawable.banana,R.drawable.fresa,R.drawable.manzana,R.drawable.una, R.drawable.orange};
        String[] titles = new String[]{"BANANA", "FRESA", "MANZANA","UVA","NARANJA"};
        String[] descrip = new String[]{"BANANA esta rico...", "FRESA esta rico...", "MANZANA esta rico...","UVA esta rico..","NARANJA esta rico.."};

         //ArrayList<DataInfo> listdata = new ArrayList<>();
        for (int i= 0; i < images.length; i++){
            DataInfo info = new DataInfo();
            info.setImg(images[i]);
            info.setTitle(titles[i]);
            info.setDescripcion(descrip[i]);
            listdata.add(info);


        }



        /*ArrayList<String> datoslist = new ArrayList<>();
        for (int i=0; i < 20; i ++){
            datoslist.add("Item"+ i);

        }*/
        //ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datoslist);
        MyAdapter adapter = new MyAdapter(this,listdata);

        list.setAdapter(adapter);

        list.setOnClickListener((View.OnClickListener) this);

        //grid.setAdapter(adapter);
        //spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = this.getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;

        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.banana_menu:{
                Toast.makeText(this,"FRESA",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.fresa_menu:{
                Toast.makeText(this,"BANANA",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return true;
       // return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     bigimg.setImageResource(listdata.get(position).getImg());

    }
}
