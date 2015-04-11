package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import persistence.ImageDaisyChain;

public class NextImageCommand implements Command {

    private final ImageDaisyChain viewer;
    private final Component parent;
    
    public NextImageCommand(ImageDaisyChain dc, Component af) {
        this.viewer = dc;
        parent = af;
    }

    @Override
    public void execute() {
        this.viewer.getNext();
        this.parent.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
