package com.example.moviemenia;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link developerInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class developerInfo extends Fragment {
ImageView imageView,imageView1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public developerInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment developerInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static developerInfo newInstance(String param1, String param2) {
        developerInfo fragment = new developerInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_developer_info, container, false);
        imageView = view.findViewById(R.id.imageView);
        imageView1 = view.findViewById(R.id.imageView1);
//        try {
//            imageView.setImageBitmap(BitmapFactory.decodeStream(new URL("").openConnection().getInputStream()));
//            imageView1.setImageBitmap(BitmapFactory.decodeStream(new URL("").openConnection().getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/Shivcoder27");
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.linkedin.com/in/shivashish-kaushik-a73643228/");
            }
        });


        return  view;
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}