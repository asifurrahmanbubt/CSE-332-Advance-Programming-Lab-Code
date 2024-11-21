import javax.swing.*;
import java.time.Year;
import java.util.Calendar;
import java.util.Calendar.*;

public class myclock extends  Thread {
    private static JFrame fr;
    private static JLabel ct;
    private static JLabel date;
    private static Calendar cal;
    private  int hr,min,sec,ampm;
    private String s;
    private  int week,month,year,day;
    private  String months[]={
            "jan","feb","mar","apr",
            "may","jun","jul","agt",
            "sep","oct","nov","dec"
    };
    private String days[]={
            "sun","mon","tue","wed","thus","fri","sat"

    };
    myclock(){
        start();

    };

    public void  run() {
        while (true) {
            //time
            cal = Calendar.getInstance();
            hr=cal.get(Calendar.HOUR);
            min=cal.get(Calendar.MINUTE);
            sec=cal.get(Calendar.SECOND);
            ampm=cal.get(Calendar.AM_PM);
            //DATE
            day=cal.get(Calendar.DAY_OF_MONTH);
            week=cal.get(Calendar.DAY_OF_WEEK);
            month=cal.get(Calendar.MONTH);
            year=cal.get(Calendar.YEAR);

            if(ampm==0) s="AM"; else s="PM";
            ct.setText("current time"+hr+":"+min+":"+sec+":"+ampm);
            date.setText(days[week+1]+"/"+day+"/"+months[month]+"/"+year);
            fr.setVisible(true);

        }
    }
    public static void main(String[] args){
         fr= new JFrame("Time");
        fr.setBounds(600,10,500,200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(null);
        fr.getContentPane().add(p);
        ct =  new JLabel("CURRENT TIME");
        ct.setBounds(10,10,480,60);
        p.add(ct);
        date =new JLabel("date");
        date.setBounds(10,70,480,60);
        p.add(date);


        fr.setVisible(true);

        new myclock();


    }

}
