package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position,long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initFruits() {
        for(int i = 0; i < 2; i ++) {
            Fruit apple = new Fruit("Apple",R.drawable.apple_1);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.banana_1);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.orange_1);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon_1);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Peat",R.drawable.pear_1);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.grappe);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.pinea_1);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry_1);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry",R.drawable.chreey_1);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.mango);
            fruitList.add(mango);
        }
    }
}
