package com.example.demo.java8.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)
 */
public class CollectorsMapMergeRunner {

    protected static enum WeekDay {
        SUNDAY(false),
        MONDAY(true),
        TUESDAY(true),
        WEDNESDAY(true),
        THURSDAY(true),
        FRIDAY(true),
        SATURDAY(false);

        private boolean workDay;

        WeekDay(boolean workDay) {
            this.workDay = workDay;
        }

        public boolean isWorkday() {
            return this.workDay;
        }
    }

    public static void main(String[] args) {
        Map<String, List<WeekDay>> workDays =
                Stream.of(WeekDay.values())
                        .collect(Collectors.toMap(
                                day -> day.name().substring(0, 1),
                                day -> List.of(day),
                                (days1, days2) -> {
                                    ArrayList result = new ArrayList<>();
                                    result.add(days1);
                                    result.add(days2);
                                    return result;
                                },
                                TreeMap::new
                        ));

        // {F=[FRIDAY], M=[MONDAY], S=[[SUNDAY], [SATURDAY]], T=[[TUESDAY], [THURSDAY]], W=[WEDNESDAY]}
        System.out.println(workDays);
    }
}
