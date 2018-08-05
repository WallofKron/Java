package project1;

/**
 * @author RobertFlorence Java 182 Ferguson
 */
public final class SystemTasks {

    private String month;
    private String message;
    private int day, hour, minute, monthnum, datenum;
    

    public SystemTasks() {
        this.month = "nul";
        this.message = null;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
    }

    public SystemTasks(String month, String message, int day, int hour, int minute) throws Exception {
        setMonth(month);
        setMessage(message);
        setDay(day);
        setHour(hour);
        setMinute(minute);
        
    }

    @Override
    public String toString() {
        String newminute;
        if (minute >= 0 && minute < 10) {
            newminute = "0" + minute;
        } else {
            newminute = "" + minute;
        }

        return "SystemTask {" + "month= " + month + ", day= " + day + ", hour= " + hour + ", minute= " + newminute + ", message= " + message + '}';
    }

    public static void main(String[] args) throws Exception {
        SystemTasks test = new SystemTasks();
        test.inputSystemTask();
        System.out.println(test.toString());

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) throws Exception {

        UserInput input = new UserInput();

        if (month.equalsIgnoreCase("Jan")) {
            this.month = month;
            this.monthnum = 1;
        } else if (month.equalsIgnoreCase("Feb")) {
            this.month = month;
            this.monthnum = 2;
        } else if (month.equalsIgnoreCase("Mar")) {
            this.month = month;
            this.monthnum = 3;
        } else if (month.equalsIgnoreCase("Apr")) {
            this.month = month;
            this.monthnum = 4;
        } else if (month.equalsIgnoreCase("May")) {
            this.month = month;
            this.monthnum = 5;
        } else if (month.equalsIgnoreCase("Jun")) {
            this.month = month;
            this.monthnum = 6;
        } else if (month.equalsIgnoreCase("Jul")) {
            this.month = month;
            this.monthnum = 7;
        } else if (month.equalsIgnoreCase("Aug")) {
            this.month = month;
            this.monthnum = 8;
        } else if (month.equalsIgnoreCase("Sep")) {
            this.month = month;
            this.monthnum = 9;
        } else if (month.equalsIgnoreCase("Oct")) {
            this.month = month;
            this.monthnum = 10;
        } else if (month.equalsIgnoreCase("Nov")) {
            this.month = month;
            this.monthnum = 11;
        } else if (month.equalsIgnoreCase("Dec")) {
            this.month = month;
            this.monthnum = 12;
        } else {
            System.out.print("Please Try Again: ");
            setMonth(input.getString(3, 3));
            this.monthnum = 0;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.length() > 0 && message.length() < 40) {
            this.message = message;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
    }

    public void inputSystemTask() throws Exception {
        UserInput input = new UserInput();

        System.out.print("Enter Month (first 3 characters): ");
        setMonth(input.getString(3, 3));

        System.out.print("Enter Day (1-31): ");
        setDay(input.getInt(1, 31));

        System.out.print("Enter Hour(0-23): ");
        setHour(input.getInt(0, 23));

        System.out.print("Enter Minute(1-60): ");
        setMinute(input.getInt(0, 59));

        System.out.print("Enter Message: ");
        setMessage(input.getString(0, 40));
    }
    public int setDatenum () throws Exception{
        
    return (monthnum-1)*31+ getDay() ;
    }
}