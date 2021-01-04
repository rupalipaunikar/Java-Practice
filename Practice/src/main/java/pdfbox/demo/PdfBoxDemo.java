package pdfbox.demo;

import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.PDDocument;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PdfBoxDemo {

    public static void addWatermark() throws IOException {
        PDDocument pdDocument = PDDocument
                .load(new File("D:\\sample.pdf"));

        // Get the pages and create a map with page number and the image to
        // be water marked.
        HashMap<Integer, String> overlayProps = new HashMap<>();
        for (int i = 0; i < pdDocument.getNumberOfPages(); i++) {
            overlayProps.put(i + 1, "D:\\donotcopy.pdf");
        }

        // Using the Overlay object add the map of properties to the PDF
        Overlay overlay = new Overlay();
        overlay.setInputPDF(pdDocument);
        overlay.setOverlayPosition(Overlay.Position.BACKGROUND);
        overlay.overlay(overlayProps);

        // Save the PDF to a new or same location
        pdDocument.save("D:\\watermark-sample.pdf");
        pdDocument.close();
        System.out.println("PDF saved to the location !!!");
    }

    public static void main(String[] args) throws IOException {
        addWatermark();
    }
}
