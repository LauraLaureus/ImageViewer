package model;

public interface Observed {

    public void hook(Observer ob);
    
    public void talk();
}
