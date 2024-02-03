package jna;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinNT;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取系统日志
 *
 * @author Iammm
 * @Time 2024/1/29 15:01
 */
public class getEvent_info {
    public static void main(String[] args) {
        new  getEvent_info().testReadEventLogEntries2();
    }
    public void testReadEventLogEntries2() {
        Advapi32Util.EventLogIterator iter = new Advapi32Util.EventLogIterator("Application");
        while (iter.hasNext()) {
            Advapi32Util.EventLogRecord record = iter.next();
            StringBuilder data = new StringBuilder();
            String[] str = record.getStrings();
            if (str == null) {
                //若任务描述为空
            } else {
                for (String s : str) {
                    data.append(s);
                }
            }
            WinNT.EVENTLOGRECORD record1 = record.getRecord();
            //get event generated time
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String generatedTime = simpleDateFormat.format(new Date(record1.TimeGenerated.longValue() * 1000));
            System.out.println(record.getRecordNumber()
                    + " Event ID: " + (short) record.getInstanceId()
                    + ", Event Type: " + record.getType()
                    + ", Event Time: " + generatedTime
                    + ": Event Category: " + record1.EventCategory.toString()
                    + ", Event Source: " + record.getSource()
                    + ", Event Description: " + data.toString());
        }
    }
}
