package pdfbox.demo;
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.*;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author jack
 */
public class OverlayDemo {

    private static PDDocument pdf;
    private static String outputFN = "D:\\output-watermark.pdf";
    private static String inputFN = "D:\\out.pdf";
    private static String stampString = "PHOTOCOPY ONLY";
    private static Float fontSize = 40f;

    public static void main(String[] args) throws IOException {
        stampPdf();
    }

    public static void stampPdf() throws IOException {

        // load the PDF to be stamped
        pdf = PDDocument.load(new File(inputFN));

        // create the overlay page with the text to be stamped
        PDDocument overlayDoc = createOverlay(stampString);

        // do the overlay
        doOverlay(pdf, overlayDoc);

        // close
        pdf.close();
        overlayDoc.close();
    }

    public static PDDocument createOverlay(String text) throws IOException {

        // Create a document and add a page to it
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // the x/y coords
        float xVal = 100f;
        float yVal = 200f;

        // Create a new font object selecting one of the PDF base fonts
        PDFont font = PDType1Font.HELVETICA;

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Create the text and position it
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.moveTextPositionByAmount(xVal, yVal);
        contentStream.drawString(text);
        contentStream.endText();

        // Make sure that the content stream is closed:
        contentStream.close();

        //return the string doc
        return document;
    }

    private static void doOverlay(PDDocument basePDF, PDDocument overlayDoc) throws IOException {
        Overlay overlay = new Overlay();
        overlay.setInputPDF(basePDF);
        overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
        overlay.setAllPagesOverlayPDF(overlayDoc);
        PDDocument output = overlay.overlay(Collections.<Integer, String>emptyMap());

        output.save(outputFN);

        overlayDoc.close();
        basePDF.close();
    }
}
