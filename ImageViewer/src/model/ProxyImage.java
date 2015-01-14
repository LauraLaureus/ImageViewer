package model;

import persistence.ImageLoader;

public class ProxyImage extends Image
{

    private final ImageLoader loader;

    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }
    private Image next;
    private Image prev;
    private Image realImage;
    
    @Override
    public Bitmap getBitmap() {
        checkLoaded();
        return realImage.getBitmap();
    }

   
    
    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setNext(Image image) {
        this.next = image;
    }

    @Override
    public void setPrev(Image image) {
        this.prev = image;
    }

    private void checkLoaded() {
        if(realImage != null) return;
        realImage = loader.load();
    }

    
}
