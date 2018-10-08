/**
 * @author Conrad Djedjebi (protected by copyrights)
 * @date 07/10/18
 * @project FiftyFive_Test
 */
package com.conrad.www.displayDates.Util;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomHandler extends Handler {

    @Override
    public void publish(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(record.getSourceClassName())
                .append(" ")
                .append(record.getSourceMethodName())
                .append(" : ")
                .append(record.getMessage());
        System.out.println(sb.toString());
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}
