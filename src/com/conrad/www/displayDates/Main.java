/**
 * @author Conrad Djedjebi (protected by copyrights)
 * @date 07/10/18
 * @project FiftyFive_Test
 */
package com.conrad.www.displayDates;

import com.conrad.www.displayDates.DataStructure.DateNode;
import com.conrad.www.displayDates.InputText.ReadInput;

public class Main {
    //text file
    private static String file = String.format(System.getProperty("user.dir") + "\\src\\com\\conrad\\www\\displayDates\\sample_text.txt");
    //data structure to store the dates
    private static DateNode dateNode = new DateNode();

    public static void main (String[]args) {
        ReadInput reader = new ReadInput();
        //extract dates from text file
        reader.extractDates(file, dateNode);
        //display extracted dates
        dateNode.displayDates();
    }
}