package com.example.demo.java8.lambdas;

import java.util.Arrays;

public class DeveloperRunner {
    public static void main(String[] args) {
        Developer[] devs = {
                new Developer("Johnny Silverhand", Developer.Level.MIDDLE, 3, "Security", "DevOps"),
                new Developer("Johnny Mnemonic", Developer.Level.MIDDLE, 2, "DevOps", "Data Science"),
                new Developer("Rick Deckard", Developer.Level.JUNIOR, 1, "AI", "Machine Learning"),
                new Developer("Kevin Flynn", Developer.Level.SENIOR, 7, "Java", "GameDev", "VR", "AR"),
                new Developer("Angela Bennett", Developer.Level.JUNIOR, 2, "QA", "Security"),
                new Developer("Thomas Anderson", Developer.Level.SENIOR, 5, "Java", "Spring", "VR"),
        };

        DeveloperFilter devFilter = new DeveloperFilter() {
            @Override
            public boolean isSuitable(Developer dev) {
                return dev.getYearsOfExperience() >= 3;
            }
        };

        for (Developer dev : devs) {
            if (devFilter.isSuitable(dev)) {
                System.out.println(dev.getName());
            }
        }

        DeveloperFilter devFilterLambda = dev -> dev.getYearsOfExperience() >= 3;

        Arrays.stream(devs)
                .filter(dev -> devFilterLambda.isSuitable(dev))
                .map(dev -> dev.getName())
                .forEach(System.out::println);

    }
}

@FunctionalInterface
interface Service {
    int doService(int value);
}

@FunctionalInterface
interface Action {
    void doAction(int num);
}

@FunctionalInterface
interface DeveloperFilter {
    boolean isSuitable(Developer developer);
}

class Developer {
    private final String name;
    private final Level level;
    private final int yearsOfExperience;
    private final String[] skills;

    public Developer(String name, Level level, int yearsOfExperience, String... skills) {
        this.name = name;
        this.level = level;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = Arrays.copyOf(skills, skills.length);
    }

    public Level getLevel() {
        return level;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String[] getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }

    enum Level {JUNIOR, MIDDLE, SENIOR, LEAD}
}