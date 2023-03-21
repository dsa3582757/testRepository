package lessonPractice;

import test.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NoobLesson {
    public static void main(String[] args){
        String string = "1222asd";
        Person person = new Person(32,175,"廖再亮");
        boolean result = string instanceof String;
        System.out.println(Math.ceil(14.58));
        ArrayList<Object> objectArrayList = new ArrayList<>();
       // Date date = new Date(1991,8,3);
        Date date =new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1991,9,3,12,0,0);
        System.out.println(simpleDateFormat.format(date));
        System.out.println(gregorianCalendar.get(Calendar.YEAR));
        String pattern = "(\\D*)(\\d+)(.*)";
        String line = "this order was placed for QT3000! OK?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if(m.find()){
            System.out.println("Found value: "+m.group(0));
        }
    }
}
