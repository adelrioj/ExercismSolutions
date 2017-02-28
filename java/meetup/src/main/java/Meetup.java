
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Meetup {

    private Integer year;
    private Integer monthOfYear;

    public Meetup(int monthOfYear, int year){
        this.monthOfYear = monthOfYear;
        this.year = year;
    }

    public DateTime day(int dayOfWeek, MeetupSchedule schedule) {

        if (MeetupSchedule.FIRST.equals(schedule)){
            return getDateByWeek(dayOfWeek, 0);
        } else if (MeetupSchedule.SECOND.equals(schedule)){
            return getDateByWeek(dayOfWeek, 1);
        } else if (MeetupSchedule.THIRD.equals(schedule)){
            return getDateByWeek(dayOfWeek, 2);
        } else if (MeetupSchedule.FOURTH.equals(schedule)){
            return getDateByWeek(dayOfWeek, 3);
        } else if (MeetupSchedule.LAST.equals(schedule)){
            LocalDate localDate = new LocalDate(this.year, this.monthOfYear, 1)
                    .withDayOfWeek(dayOfWeek);
            return localDate.dayOfWeek().withMaximumValue().toDateTimeAtStartOfDay();
        } else if (MeetupSchedule.TEENTH.equals(schedule)){

        }
    }

    private DateTime getDateByWeek(int dayOfWeek, int weekNumber) {
        return new LocalDate(this.year, this.monthOfYear, 1)
                .withDayOfWeek(dayOfWeek)
                .plusWeeks(weekNumber)
                .toDateTimeAtStartOfDay();
    }

}
