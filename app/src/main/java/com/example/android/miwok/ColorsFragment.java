package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ArrayList<word> words = new ArrayList<word>();
        words.add(new word("red", "weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new word("green", "chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new word("white", "kelelli",R.drawable.color_white,R.raw.color_white));

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private  void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
