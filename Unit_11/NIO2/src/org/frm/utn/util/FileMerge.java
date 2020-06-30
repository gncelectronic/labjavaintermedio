package org.frm.utn.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMerge {

	   private Path form;
	    private Path list;
	    private String nameToken = "<NAME>";
	    private Pattern p = Pattern.compile(nameToken);
	    private List<String> formLetter;
	    private List<String> customLetter;
	    private List<String> nameList;

	    public FileMerge(Path form, Path list) {
	        this.form = form;
	        this.list = list;
	    }

	    
	    public void writeMergedForms() throws IOException {
	        
	        Charset cs = Charset.defaultCharset();
	        formLetter = Files.readAllLines(form, cs);
	       
	        nameList = Files.readAllLines(list, cs);
	        
	        for (int j = 0; j < nameList.size(); j++) {
	            customLetter = new ArrayList<>();
	            
	            String formName = nameList.get(j).replace(' ', '_').concat(".txt");
	            Path formOut = form.getParent().resolve(formName);
	            for (int k = 0; k < formLetter.size(); k++) {
	                if (hasToken(formLetter.get(k))) {
	                    customLetter.add(mergeName(formLetter.get(k), nameList.get(j)));
	                } else {
	                    customLetter.add(formLetter.get(k));
	                }
	            }
	            
	            Files.write(formOut, customLetter, cs);
	            System.out.println ("Wrote form letter to: " + nameList.get(j));
	        }
	    }

	    
	    private String mergeName(String form, String name) {
	        Matcher m = p.matcher(form);
	        return (m.replaceFirst(name));
	    }

	    
	    private boolean hasToken(String s) {
	        Matcher m = p.matcher(s);
	        return m.find();
	    }
}
