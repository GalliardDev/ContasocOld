package es.yoshibv.contasoc.util;

import java.awt.*;
import java.awt.print.*;

public class PrintableList implements Printable {
    private java.util.List<String> list;

    public PrintableList(java.util.List<String> list) {
        this.list = list;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex >= list.size()) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        int lineHeight = graphics.getFontMetrics().getHeight();
        int itemsPerPage = (int) (pageFormat.getImageableHeight() / lineHeight);

        int startIndex = pageIndex * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, list.size());

        for (int i = startIndex; i < endIndex; i++) {
            int lineIndex = i - startIndex;
            String line = list.get(i);
            int yPos = (lineIndex + 1) * lineHeight;
            g2d.drawString(line, 0, yPos);
        }

        return PAGE_EXISTS;
    }
}
