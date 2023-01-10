package com.example.demo.java8.other;

import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CustomCollectorRunner {

    protected enum WeekDay {
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

        public boolean isWorkday(){
            return this.workDay;
        }
    }

    /**
     * Supplier<A> supplier() is a function that creates containers to collect elements.
     * BiConsumer<A,T> accumulator() is a function that puts a new element in a container instance.
     * BinaryOperator<A> combiner() is a function that combines two container instances into one. It is used in parallel streams: Each part can be assembled into a separate instance of the container.
     * Function<A,R> finisher() is a function that transforms the container instance into the final result. This function is needed when you do not want to return the container with all its capabilities. As when you collect elements to a StringBuilder, you would like to return a String instance as a final result.
     * Set<Characteristics> characteristics() returns the characteristics of the collector so that the Stream.collect() method can handle it well.
     * Here are possible characteristics:
     * CONCURRENT—the collector that supports working in the concurrent environment.
     * UNORDERED—the collector functioning does not depend on the order of the incoming elements.
     * IDENTITY_FINISH—the finisher() function will not be applied.
     */
    public static void main(String[] args) {
        // new Collector<T, A, R> T
        // T - Type of input elements
        // A - Type of container the elements will be placed into
        // R - Result type
        String workDays = Stream.of(WeekDay.values())
                .collect(new Collector<WeekDay, StringJoiner, String>() {
                    @Override
                    public Supplier<StringJoiner> supplier() {
                        return () -> new StringJoiner(":");
                    }

                    @Override
                    public BiConsumer<StringJoiner, WeekDay> accumulator() {
                        return (joiner, weekday) -> joiner.add(weekday.name().substring(0, 2));
                    }

                    @Override
                    public BinaryOperator<StringJoiner> combiner() {
                        return (joiner1, joiner2) -> joiner1.merge(joiner2);
                    }

                    @Override
                    public Function<StringJoiner, String> finisher() {
                        return joiner -> joiner.toString();
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of();
                    }
                });

        // SU:MO:TU:WE:TH:FR:SA
        System.out.println(workDays);
    }
}
