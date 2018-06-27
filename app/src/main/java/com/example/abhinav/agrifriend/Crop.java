package com.example.abhinav.agrifriend;

/**
 * Created by abhin on 20-Nov-17.
 */

public class Crop {

    /** Default translation for the crop */
    private String mDefaultTranslation;

    /** Kannada translation for the crop */
    private String mKannadaTranslation;

    /** Image resource ID for the crop */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this crop */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Crop(String defaultTranslation, String kannadaTranslation) {
        mDefaultTranslation = defaultTranslation;
        mKannadaTranslation = kannadaTranslation;
    }

    public Crop(String defaultTranslation, String kannadaTranslation, int imageResourceId) {
        mDefaultTranslation = defaultTranslation;
        mKannadaTranslation = kannadaTranslation;
        mImageResourceId = imageResourceId;
    }

    /*
        Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /*
      Get the Miwok translation of the word.
     */
    public String getmKannadaTranslation() {
        return mKannadaTranslation;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
