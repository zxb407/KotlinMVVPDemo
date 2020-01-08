package com.jjshouse.kotlinmvvpdemo.utils.glideutils.options;

public class GlideOptions {
    private boolean doAnimate;
    private int replaceImage;
    private int errImage;

    public GlideOptions() {
    }

    public GlideOptions(int replaceImage, boolean doAnimate) {
        this(replaceImage, replaceImage, doAnimate);
    }

    public GlideOptions(int replaceImage, int errImage, boolean doAnimate) {
        this.doAnimate = doAnimate;
        this.replaceImage = replaceImage;
        this.errImage = errImage;
    }

    public boolean getDoAnimate() {
        return doAnimate;
    }

    public void setDoAnimate(boolean doAnimate) {
        this.doAnimate = doAnimate;
    }

    public int getReplaceImage() {
        return replaceImage;
    }

    public void setReplaceImage(int replaceImage) {
        this.replaceImage = replaceImage;
    }

    public int getErrImage() {
        return errImage;
    }

    public void setErrImage(int errImage) {
        this.errImage = errImage;
    }
}
