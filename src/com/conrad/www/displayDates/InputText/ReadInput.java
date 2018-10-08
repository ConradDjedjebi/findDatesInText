/**
 * @author Conrad Djedjebi (protected by copyrights)
 * @date 07/10/18
 * @project FiftyFive_Test
 */
package com.conrad.www.displayDates.InputText;

import com.conrad.www.displayDates.DataStructure.DateNode;
import com.conrad.www.displayDates.Util.CustomHandler;

import java.io.*;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.lang.String;
import java.util.Calendar;
import java.text.ParsePosition;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadInput {
    //------------------------------------ MEMBERS ---------------------------------//
    private Locale id = new Locale("en", "US");
    private List<SimpleDateFormat> knownPatterns = new ArrayList<SimpleDateFormat>();
    private static Logger LOGGER = Logger.getLogger(ReadInput.class.getName());

    //------------------------------------ CONSTRUCTORS ---------------------------------//
    /**
     * Default constructor of object ReadInput
     **/
    public ReadInput() {
        DateFormatSymbols dfs = new DateFormatSymbols(id);
        knownPatterns.add(new SimpleDateFormat("MMM dd, yyyy", dfs)); //May 15, 2014 pattern
        knownPatterns.add(new SimpleDateFormat("dd MMM yyyy", dfs));  //20 May 2014 pattern
        knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd", dfs));  //2016-04-07 pattern
        LOGGER.addHandler(new CustomHandler());
        LOGGER.setLevel(Level.OFF);
    }

    //------------------------------------ METHODS --------------------------------//
    /**
     * parseDates(): look for dates in the text
     *
     * Date detection is limited to US locale (ISO 639 & ISO 3166 : en/US)
     * Date detection is limited to the patterns referenced in this.knownPatterns
     *
     * @param text the text to parse
     * @param dateNode root of the date graph
     **/
    private void parseDates (String text, DateNode dateNode) {
        LOGGER.info("parsing the text");
        ParsePosition parseP = new ParsePosition(0);
        while(parseP.getIndex() < (text.length()-1)) {
            for (SimpleDateFormat pattern : knownPatterns) {
                try {
                    Date date = new Date(pattern.parse(text, parseP).getTime());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    dateNode.addToGraph(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
                    continue;
                } catch (NullPointerException e) {
                    LOGGER.config("NullPointerException");
                }
            }
            parseP.setIndex(parseP.getIndex()+1);
        }
    }

    /**
     * readFile(): read the text file
     *
     * @param file file containing the text
     * @return : the text contained in the file
     **/
    public String readFile (String file) {
        LOGGER.info("reading text file");
        String line = null;
        try {
            FileReader fileReader = new FileReader(file);
            try {
                BufferedReader br = new BufferedReader(fileReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        sb.append("\n");
                        line = br.readLine();
                    }
                    String text = sb.toString();
                    LOGGER.config(text);
                    LOGGER.config("Text lenght :" + text.length());
                    return text;
                } finally {
                    br.close();
                }
            }catch(IOException e){
                LOGGER.severe(
                        "Error reading file '"
                                + file + "'");
                //e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            LOGGER.severe(
                    "Unable to open file '" +
                            file + "'");
        }
        //default
        return null;
    }

    /**
     * parseDates(): read text file and look for dates
     *
     * @param file file containing the text
     * @param dateNode root of the date graph
     **/
    public void extractDates (String file, DateNode dateNode){
        String text = readFile(file);
        parseDates(text, dateNode);
    }
}