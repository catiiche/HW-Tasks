package com.ifmo.jjd.hw6;

import com.ifmo.jjd.Lesson6.ColouringBook;

import java.util.Arrays;

public class GroupForClimbing {
    private boolean isGroupRecruitment;
    private Mountain mountain;
    private Climber[] groupOfClimbers;

    public GroupForClimbing(boolean isGroupRecruitment, Mountain mountain, Climber[] climbers) {
        setMountain(mountain);
        setClimbers(groupOfClimbers);
        setGroupRecruitment(isGroupRecruitment);
    }

    public boolean isGroupRecruitment() {
        return isGroupRecruitment;
    }

    public void setGroupRecruitment(boolean groupRecruitment) {
        isGroupRecruitment = groupRecruitment;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        if (mountain == null)
            throw new IllegalArgumentException("mountain не должен быть равен null");
        this.mountain = mountain;
    }

    public Climber[] getClimbers() {
        return groupOfClimbers;
    }

    public void setClimbers(Climber[] groupOfClimbers) {
        if (groupOfClimbers == null)
            throw new IllegalArgumentException("climbers не должен быть равен null");
        this.groupOfClimbers = groupOfClimbers;
    }

    public void addClimbers(Climber... climbers) {
        for (int i = 0; i < groupOfClimbers.length; i++) {
            for (int j = 0; j < climbers.length; j++) {
                if (groupOfClimbers[j] == null) {
                    groupOfClimbers[j] = climbers[i];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(climbers));
    }

}
