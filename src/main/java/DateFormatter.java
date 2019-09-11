
/**
* This method handles the operation to format the user-inputted date/time into a standardised format
*/

public class DateFormatter {

    /**
     * This method formats the user-inputted date/time into a standardised format
     * @param s This is the inputted string to be parsed into a standardised format
     * @return Returns the formatted date/time as a string
     */

    public static String formatDate(String s){
        String date, time;
        String[] month_name = {"January", "February", "March", "April", "May", "June", "July", "August",
                                "September", "October", "November", "December"};

        String[] tokens = s.split("\\s+");

        date = tokens[0];
        int day_int = Integer.parseInt(date.split("/")[0]);
        String day;
        String month = date.split("/")[1];
        String year = date.split("/")[2];


        switch(day_int){
            case 1:
            case 21:
            case 31:
                day = day_int + "st";
                break;
            case 2:
            case 22:
                day = day_int + "nd";
                break;
            case 3:
            case 23:
                day = day_int + "rd";
                break;
            default:
                day = day_int + "th";

        }

        month = month_name[Integer.parseInt(month)- 1];

        date = day + " " + month + " " + year;

        if (tokens.length == 2) {
            time = tokens[1];
            String t_suffix ="am";

            int t = Integer.parseInt(time);
            if ( t >= 1300){
                t = t - 1200;
                t_suffix = "pm";
            }
            else if ( t >= 1200 ){
                t_suffix = "pm";
            }

            int hour = t / 100;
            int min = t % 100;

            if (min == 0) {
                date = String.format("%s %d%s", date, hour, t_suffix);
            }
            else if(min < 10){
                date = String.format("%s %d.0%d%s", date, hour, min, t_suffix);
            }
            else {
                date = String.format("%s %d.%d%s", date, hour, min, t_suffix);
            }
        }

        return date;
    }
}
