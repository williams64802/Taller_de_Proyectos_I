package com.example.ecogotas;


import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class Datos extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPagerAdapter adapter;
    private LinearLayout dotsLayout;
    private Button btnBack,btnNex;

    private String[] content={"¡Bienvenido a EcoGotas!","Como Ahorrar","Bienvenidos","Registro de Datos"};
    private String[] title={"El 1% del agua en la Tierra es accesible para nosotros. Tu compromiso con EcoGotas conserva este recurso vital",
            "Como Ahorrar","Registre Datos"};
    private int[] image={R.drawable.carga_png,R.drawable.escaces1,R.drawable.escaces2,R.drawable.carga_png};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_datos);
        viewPager=findViewById(R.id.viewPager);
        btnBack=findViewById(R.id.btnBack);
        btnNex=findViewById(R.id.btnNext);
        dotsLayout=findViewById(R.id.layoutDots);
        loadViewPager();
    }

    private void loadViewPager(){
        adapter=new MyViewPagerAdapter(getSupportFragmentManager());
        for(int i=0;i<title.length;i++){
            adapter.addFragment(newIntance(title[i],content[i],image[i]));
        }
        viewPager.setAdapter(adapter);

    }

    private SliderFragment newIntance(String title,String content,int image){
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        bundle.putString("content",content);
        bundle.putInt("image",image);

        SliderFragment sliderFragment=new SliderFragment();
        sliderFragment.setArguments(bundle);
        return sliderFragment;
    }
}