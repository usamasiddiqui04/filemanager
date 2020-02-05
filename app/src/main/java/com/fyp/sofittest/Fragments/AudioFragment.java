package com.fyp.sofittest.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyp.sofittest.Model.AudioModel;
import com.fyp.sofittest.R;
import com.fyp.sofittest.helpers.ImagePathProvider;
import com.fyp.sofittest.helpers.MediaPathProvider;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class AudioFragment extends Fragment {


    public AudioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_audio, container, false);

        MediaPathProvider mediaPathProvider = new MediaPathProvider();
        mediaPathProvider.getAllAudioFromDevice(getActivity());


        return view ;
    }

}
