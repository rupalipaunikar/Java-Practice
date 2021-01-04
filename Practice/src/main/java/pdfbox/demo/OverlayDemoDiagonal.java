package pdfbox.demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;
import org.apache.pdfbox.util.Matrix;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OverlayDemoDiagonal {

    public static void main(final String[] args) throws IOException {
        final File srcFile = new File("D:\\out.pdf");
        final File dstFile = new File("D:\\output-watermark.pdf");
        final String text = "PHOTOCOPY ONLY";
        // Loader class not found in original sample
        try (PDDocument doc = PDDocument.load(srcFile)) {
            // Loop through each page to add text water mark on each page
            for (final PDPage page : doc.getPages()) {
                final PDFont font = PDType1Font.HELVETICA_BOLD_OBLIQUE;

                addWatermarkText(doc, page, font, text);
            }
            doc.save(dstFile);
        }

    }

    private static void addWatermarkText(final PDDocument doc, final PDPage page, final PDFont font, final String text)
            throws IOException {
        try (PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true,
                true)) {
            final float fontHeight = 80; // arbitrary for short text
            final float width = page.getMediaBox().getWidth();
            final float height = page.getMediaBox().getHeight();
            final float stringWidth = font.getStringWidth(text) / 1000 * fontHeight;
            final float diagonalLength = (float) Math.sqrt(width * width + height * height);
            final float angle = (float) Math.atan2(height, width);
            final float x = (diagonalLength - stringWidth) / 2; // "horizontal" position in rotated world
            final float y = -fontHeight / 4; // 4 is a trial-and-error thing, this lowers the text a bit
            cs.transform(Matrix.getRotateInstance(angle, 0, 0));
            cs.setFont(font, fontHeight);
            //cs.setRenderingMode(RenderingMode.STROKE); // for "hollow" effect

            final PDExtendedGraphicsState gs = new PDExtendedGraphicsState();
            gs.setNonStrokingAlphaConstant(0.2f);
            gs.setStrokingAlphaConstant(0.2f);
            gs.setBlendMode(BlendMode.MULTIPLY);
            gs.setLineWidth(3f);
            cs.setGraphicsStateParameters(gs);

            // Set color
            cs.setNonStrokingColor(Color.darkGray);
            cs.setStrokingColor(Color.darkGray);

            cs.beginText();
            cs.newLineAtOffset(x, y);
            cs.showText(text);
            cs.endText();
        }
    }
}

