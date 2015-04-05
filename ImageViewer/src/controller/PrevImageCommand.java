package controller;

import java.awt.event.ActionEvent;
import persistence.ImageDaisyChain;
import ui.swing.ApplicationFrame;

public class PrevImageCommand implements Command {

    private final ImageDaisyChain viewer;
    private final ApplicationFrame parent;
    
    public PrevImageCommand(ImageDaisyChain dc, ApplicationFrame af) {
        this.viewer = dc;
        parent = af;
    }

    @Override
    public void execute() {
        this.viewer.getPrevious();
        this.parent.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
