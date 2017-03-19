package com.gmail.toddbroll;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 * Created by tbroll on 3/19/17.
 */
 class KnockKnockFactory {
 private static final String[] KKJokesP1 =
         {"turnip", "cows go", "little old lad", "nana", "etch"};

 private static final String[] KKJokesP2 =
         {"turnip the heat, it's cold in here", "Silly you, cows go moo",
                 "I didn't know you could yodel", "nana your business", "bless you"};

 public static String[] getJoke(){
  String[] joke = new String[2];
  double in = Math.random() * (KKJokesP1.length-1);
  int index =(int)Math.round(in);
  joke[0] = KKJokesP1[index];
  joke[1] = KKJokesP2[index];
  return joke;
 }
 public static String buildXML(String[] joke){
  Document document;
  Element root;
  Element lead;
  Element punchline;

  document = new Document();
  root = new Element("jokes");
  document.setRootElement(root);

  lead = new Element("lead");
  lead.addContent(joke[0]);

  punchline = new Element("punchline");
  punchline.addContent(joke[1]);

  root.addContent(lead);
  root.addContent(punchline);

  XMLOutputter xmlOut = new XMLOutputter();
  System.out.println(xmlOut.outputString(document));

  return xmlOut.outputString(document);
 }
 public static void main(String [] args){
  String [] test = getJoke();
  String xml = buildXML(test);
  System.out.println(xml);
 }
}
