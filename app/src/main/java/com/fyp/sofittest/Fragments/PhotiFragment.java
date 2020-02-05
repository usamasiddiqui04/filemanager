package com.fyp.sofittest.Fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyp.sofittest.Adapters.RecyclerAdapter;
import com.fyp.sofittest.R;
import com.fyp.sofittest.helpers.ImagePathProvider;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotiFragment extends Fragment {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> imageData = new ArrayList<String>();
    private RecyclerView.Adapter adapter;
    private Context context ;


    public PhotiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photi, container, false);
        context = getActivity();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        imageData = ImagePathProvider.getAllImagesPath(getActivity());
        adapter = new RecyclerAdapter(imageData);
        recyclerView.setAdapter(adapter);

        for (int i = 0 ; i < imageData.size() ; i ++ )
            Log.d("Imges" , imageData.get(i));

        return view;
    }
}
