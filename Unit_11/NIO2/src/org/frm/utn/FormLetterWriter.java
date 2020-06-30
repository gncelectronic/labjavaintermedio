package org.frm.utn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.frm.utn.util.FileMerge;

public class FormLetterWriter {

	  public static void main(String[] args) {
          Path form = null;
        Path list = null;
        
        if (args.length < 2) {
            System.out.println("Usage: FormLetter <form template file> <name list file>");
            System.exit(-1);
        }
        
        
        form = Paths.get(args[0]);
        list = Paths.get(args[1]);
        if (!Files.isRegularFile(form) || !Files.isRegularFile(list)) {
            System.out.println("Form template and Name list must be files");
            System.exit(-1);
        }
        
        FileMerge fm = new FileMerge(form, list);
        try {
            fm.writeMergedForms();
        } catch (IOException i) {
            System.out.println("Exception: " + i);
        }
    }
}
