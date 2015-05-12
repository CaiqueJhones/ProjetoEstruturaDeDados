package br.edu.ufrb.estruturadedados.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class PanelCode extends JPanel {

	private static final String[] KEYWORDS = new String[] { "abstract",
			"assert", "boolean", "break", "byte", "case", "catch", "char",
			"class", "const", "continue", "default", "do", "double", "else",
			"enum", "extends", "final", "finally", "float", "for", "goto",
			"if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "package", "private", "protected",
			"public", "return", "short", "static", "strictfp", "super",
			"switch", "synchronized", "this", "throw", "throws", "transient",
			"try", "void", "volatile", "while", "null" };

	private static final String KEYWORD_PATTERN = "\\b("
			+ String.join("|", KEYWORDS) + ")\\b";
	private static final String PAREN_PATTERN = "\\(|\\)";
	private static final String BRACE_PATTERN = "\\{|\\}";
	private static final String BRACKET_PATTERN = "\\[|\\]";
	private static final String SEMICOLON_PATTERN = "\\;";
	private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
	private static final String COMMENT_PATTERN = "//[^\n]*" + "|"
			+ "/\\*(.|\\R)*?\\*/";
	private static final String ANNOTATION_PATTERN = "@[^\\s\n]*";
	
	private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
            + "|(?<PAREN>" + PAREN_PATTERN + ")"
            + "|(?<BRACE>" + BRACE_PATTERN + ")"
            + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
            + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
            + "|(?<STRING>" + STRING_PATTERN + ")"
            + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
            + "|(?<ANNOTATION>" + ANNOTATION_PATTERN + ")"
    );
	
	private static final String sampleCode = String.join("\n", new String[] {
	        "package com.example;",
	        "",
	        "import java.util.*;",
	        "",
	        "public class Foo extends Bar implements Baz {",
	        "",
	        "    /*",
	        "     * multi-line comment",
	        "     */",
	        "    public static void main(String[] args) {",
	        "        // single-line comment",
	        "        for(String arg: args) {",
	        "            if(arg.length() != 0)",
	        "                System.out.println(arg);",
	        "            else",
	        "                System.err.println(\"Warning: empty string as argument\");",
	        "        }",
	        "    }",
	        "",
	        "}"
	    });

	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	public PanelCode() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Courier New", Font.PLAIN, 12));
		textPane.setEditable(false);
		add(new JScrollPane(textPane));
		
		setText(sampleCode);
		//textPane.getStyledDocument().setCharacterAttributes(0, 10, getMyAttributeSet(1), true);
	}
	
	public void setText(String text){
		textPane.setText(text);
		String lines[] = text.split("\n");
		StyledDocument styled = textPane.getStyledDocument();
		int next=0;
		for (String string : lines) {
			
			Matcher matcher = PATTERN.matcher(string);
	        while(matcher.find()) {
	            AttributeSet styleClass =
	                    matcher.group("KEYWORD") != null ? getMyAttributeSet(1) :
	                    matcher.group("PAREN") != null ? getMyAttributeSet(2) :
	                    matcher.group("BRACE") != null ? getMyAttributeSet(3) :
	                    matcher.group("BRACKET") != null ? getMyAttributeSet(4) :
	                    matcher.group("SEMICOLON") != null ? getMyAttributeSet(5) :
	                    matcher.group("STRING") != null ? getMyAttributeSet(6) :
	                    matcher.group("COMMENT") != null ? getMyAttributeSet(7) :
	                    matcher.group("ANNOTATION") != null ? getMyAttributeSet(8) :
	                    getMyAttributeSet(0); /* never happens */ assert styleClass != null;
	            
	            styled.setCharacterAttributes(matcher.start()+next, (next+matcher.end()) - (next+matcher.start()), styleClass,
	            		true);
	        }
	        next += string.length()+1;
		}

	}
	
	private SimpleAttributeSet getMyAttributeSet(int type){
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setForeground(attr, getCharColor(type));
		if(type == 1)
			StyleConstants.setBold(attr, true);
		else
			StyleConstants.setBold(attr, false);
		return attr;
	}
	
	private Color getCharColor(int type){
		if(type == 1){
			return Color.blue;  
		}else if(type == 2){
			return Color.black; 
		}else if(type == 3){
			return Color.black; 
		}else if(type == 4){
			return Color.black; 
		}else if(type == 5){
			return Color.black; 
		}else if(type == 6){
			return Color.MAGENTA; 
		}else if(type == 7){
			return new Color(100, 180, 100); 
		}else if(type == 8){
			return new Color(200, 200, 200); 
		}
		return Color.black;
	}

}
