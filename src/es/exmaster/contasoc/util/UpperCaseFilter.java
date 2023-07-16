package es.exmaster.contasoc.util;

import javax.swing.text.*;

public class UpperCaseFilter extends DocumentFilter
{
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
        throws BadLocationException
    {
        replace(fb, offs, 0, str, a);
    }

    public void replace(FilterBypass fb, final int offs, final int length, final String text, final AttributeSet a)
        throws BadLocationException
    {
        if (text != null)
        {
            super.replace(fb, offs, length, text.toUpperCase(), a);
        }
    }
}