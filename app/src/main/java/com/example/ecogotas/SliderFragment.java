package com.example.ecogotas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SliderFragment extends Fragment {

    View view;
    ImageView image;
    TextView title, content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_slider,container,false);
        image=view.findViewById(R.id.image);
        title=view.findViewById(R.id.txtTitle);
        content=view.findViewById(R.id.txtContent);
        RelativeLayout background=view.findViewById(R.id.background);
        if(getArguments()!=null){
            title.setText(getArguments().getString("title"));
            content.setText(getArguments().getString("content"));
            image.setImageResource(getArguments().getInt("image"));
        }



        return view;
    }
}
