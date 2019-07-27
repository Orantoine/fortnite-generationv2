package fr.orantoine.fortnitegenerationv2.services;

import fr.orantoine.fortnitegenerationv2.models.Day;
import fr.orantoine.fortnitegenerationv2.models.Match;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.joda.time.DateTimeFieldType.dayOfMonth;

public class DayService {

    public DayService() {
    }


    public List<Day> getDays(List<Match> matchs) {
        List<Day> dayList = new ArrayList<>();
        for (Match match: matchs) {
            boolean present = false;
            Date date = match.getDateCollected();
            DateTime dateTime = new DateTime(date);
            DateTime dateTime1 = new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.getDayOfMonth(),4,0);
            Date dateJour = dateTime1.toDate();
            for (Day day:dayList) {
                if(day.getDay().equals(dateJour)){
                    List<Match> matchList = day.getMatches();
                    matchList.add(match);
                    day.setMatches(matchList);
                    present = true;
                }
            }
            if(!present){
                Day newDay = new Day();
                newDay.setDay(dateJour);
                List<Match> newMatchList = new ArrayList<>();
                newMatchList.add(match);
                newDay.setMatches(newMatchList);
                dayList.add(newDay);
            }
        }
        return dayList;
    }
}
