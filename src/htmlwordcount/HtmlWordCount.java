/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlwordcount;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.parser.ParserDelegator;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.MutableAttributeSet;

/**
 *
 * @author eulinle_sd2082
 */
public class HtmlWordCount {

    public HtmlWordCount() {
    }

    public static List<String> extractText(Reader reader) throws IOException {
        final ArrayList<String> list = new ArrayList<String>();

        ParserDelegator parserDelegator = new ParserDelegator();
        ParserCallback parserCallback = new ParserCallback() {
            @Override
            public void handleText(final char[] data, final int pos) {
                list.add(new String(data));
            }

            @Override
            public void handleStartTag(Tag tag, MutableAttributeSet attribute, int pos) {
            }

            @Override
            public void handleEndTag(Tag t, final int pos) {
            }

            @Override
            public void handleSimpleTag(Tag t, MutableAttributeSet a, final int pos) {
            }

            @Override
            public void handleComment(final char[] data, final int pos) {
            }

            @Override
            public void handleError(final java.lang.String errMsg, final int pos) {
            }
        };
        parserDelegator.parse(reader, parserCallback, true);
        return list;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader("usc.html");
        List<String> lines = HtmlWordCount.extractText(reader);
        int b = lines.size();
        List myList = new ArrayList();
        int counter = 0;

        for (String line : lines) {
            String[] z = line.split(" ");
            for (String x : z) {
                System.out.println(x);
            }
        }

    }

}
