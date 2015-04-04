package imageviewer;

import model.Image;
import ui.ImageViewer;
import persistence.ImageLoader;
import ui.swing.ApplicationFrame;
import controller.NextImageCommand;
import controller.PrevImageCommand;
import model.Bitmap;
import model.ProxyImage;
import model.RealImage;
import ui.swing.SwingImageViewerPanel;
import java.awt.event.ActionListener;



public class SwingApplication {

    //FOR NEXT VERSIONS: seleccionar la carpeta desde donde queremos leer las imágenes.
    public static void main(String[] args) {
        new SwingApplication().execute();
    }
   
    
    private void execute() {
        Image[] images = linkImages(createImages()); 
        ImageViewer viewer = createImageViewer(images[0]);
        createApplicationFrame(createCommands(viewer), (SwingImageViewerPanel) viewer);
    }

    //FOR NEXT VERSIONS: array de imágenes que dependa del número de imágenes que tenga la carpeta
    private Image[] createImages() {
        Image[] images = new Image[6];
        for (int i = 0; i < images.length; i++) images[i] = createImage(i);
        return images;
    }

    private Image createImage(final int index) {
        final String ROOT = "images/";
        final String[] images = {"monster.jpg", "koala.jpg", "jellyfish.jpg", "evolution.jpg", "water.jpg", "skelleton.jpg"};
        return new ProxyImage(new ImageLoader() {
            @Override
            public Image load() {
                return new RealImage(new Bitmap(ROOT + images[index]));
            }
        });
    }

    private Image[] linkImages(Image[] images) {
        for (int i = 0; i < images.length; i++) {
            Image image = images[i];
            Image next = images[(i + 1) % images.length];
            Image prev = images[(i + images.length - 1) % images.length];
            image.setNext(next);
            image.setPrev(prev);
        }
        return images;
    }

    private ImageViewer createImageViewer(Image image) {
        return new SwingImageViewerPanel(image);
    }

    private ApplicationFrame createApplicationFrame(ActionListener[] listeners, SwingImageViewerPanel viewer) {
        return new ApplicationFrame(listeners, viewer);
    }

    private ActionListener[] createCommands(ImageViewer viewer) {
        return new ActionListener[] {
            new PrevImageCommand(viewer),
            new NextImageCommand(viewer)
        };
    }
    
}
