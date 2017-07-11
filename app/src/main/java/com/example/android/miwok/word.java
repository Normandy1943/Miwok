package com.example.android.miwok;

/**
 * Created by you on 2017/7/5.
 */

public class word {
    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;
    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;

    /**
     * Audio resource ID for the word
     */
    private int mAudioResourceId;

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * +     * Create a new Word object.
     * +     *
     * +     * @param defaultTranslation is the word in a language that the user is already familiar with
     * +     *                           (such as English)
     * +     * @param miwokTranslation is the word in the Miwok language
     * * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * +     * Get the default translation of the word.
     * +
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * +     * Get the Miwok translation of the word.
     * +
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Create a new Word object
     */

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}



