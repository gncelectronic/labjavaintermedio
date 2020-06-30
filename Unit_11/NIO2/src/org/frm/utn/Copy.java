package org.frm.utn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.frm.utn.util.CopyFileTree;

public class Copy {
	
	public static void main(String[] args) {
        boolean overwrite = false;
        boolean prompt = false;
       
        if (args.length < 2) {
            error("Usage: java Copy <source directory> <target directory");
        } else if (args[0].equals(args[1])) {  // Check if the directories are different
            error("source and target cannot be the same directory");
        }

       
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        
        if (Files.notExists(source)) {
            error("The source must exist: " + source);
        }

        
        if (!target.isAbsolute()) {
            Path base = source.subpath(0, source.getNameCount() - 1);
            target = Paths.get(source.getRoot().toString(), base.toString(), target.toString());
        }

        
        if (Files.exists(target)) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

                //equalsIngnoreCase  no toma encuenta si es mayuscula o minuscula
                System.out.print("Target directory exists. Overwrite existing files? (yes/no): ");
                String s = in.readLine().trim();
                if (!(s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes"))) {
                    error("Choose an empty target directory or file.");
                }
            } catch (IOException e) {
                error("Console I/O exception: " + e);
            }
        } else {
          
            try {
                target = Files.createDirectories(target);
            } catch (IOException e) {
                error("Exception creating target directory: " + e);
            }
        }

       
        CopyFileTree cft = new CopyFileTree(source, target);
        try {
            Files.walkFileTree(source, cft);
        } catch (IOException e) {
            error("WalkFileTree Exception: " + e);
        }
        System.out.println("Successfully copied " + source + " to " + target);

    }

    
    public static void error(String message) {
        System.err.println(message);
        System.exit(-1);
    }

}
