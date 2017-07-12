package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        /**
         * This listener gets triggered whenever the audio focus changes
         * (i.e., we gain or lose audio focus because of another app or device).
         */


        // Create Array of English Numbers 数组
        /*String words[] = new String[]{
                getResources().getString(R.string.eng_1), getResources().getString(R.string.eng_2),
                getResources().getString(R.string.eng_3), getResources().getString(R.string.eng_4),
                getResources().getString(R.string.eng_5), getResources().getString(R.string.eng_6),
                getResources().getString(R.string.eng_7), getResources().getString(R.string.eng_8),
                getResources().getString(R.string.eng_9), getResources().getString(R.string.eng_10)
        };

        for (int i = 0; i < words.length; i++) {
            Log.v("NumbersActivity", "Word at index " + i + ": " + words[i]);
        }*/


        // Create Array of English Numbers 数组列表
        ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(
                getResources().getString(R.string.eng_1), getResources().getString(R.string.eng_2),
                getResources().getString(R.string.eng_3), getResources().getString(R.string.eng_4),
                getResources().getString(R.string.eng_5), getResources().getString(R.string.eng_6),
                getResources().getString(R.string.eng_7), getResources().getString(R.string.eng_8),
                getResources().getString(R.string.eng_9), getResources().getString(R.string.eng_10)
        ));

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));


        /*for (int i = 0; i < wordsList.size(); i++)
            Log.v("NumbersActivity", "wordsList.get(" + i + ") : " + wordsList.get(i) + "\n");
        }*/

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        //while循环
       /* int index = 0;
        while (index < wordsList.size()) {
            TextView wordView = new TextView(this);
            wordView.setText(wordsList.get(index));
            rootView.addView(wordView);
            index++;
        }*/

        //for循环
        /*for (int index=0;index<wordsList.size();index++){
            TextView wordView = new TextView(this);
            wordView.setText(wordsList.get(index));
            rootView.addView(wordView);
        }*/


        //增强for循环
        /*for (String word : wordsList) {
            TextView wordView = new TextView(this);
            wordView.setText(word);
            rootView.addView(wordView);
        }*/

        //GridView显示单词
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
       /* ArrayAdapter<word> itemsAdapter = new ArrayAdapter(this, R.layout.list_item, words);
        GridView gridView = (GridView) findViewById(R.id.list_item);
        gridView.setAdapter(itemsAdapter);*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                word word = words.get(i);


                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceId());
                    mMediaPlayer.start();

                /*mediaPlayer.setOnCompletionListener(
                        new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                releaseMediaPlayer();
                            }
                        });*/
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
