package com.ifmo.jjd.Lesson8.Homework8School;

public class School {
    private final String name;
    private Principal principal;
    protected Teachers[] teachers;
    protected Pupils[] pupils;

    public School(String name, Principal principal) {
        if (name == null || name.length() < 3)
            throw new IllegalArgumentException("name должен быть не меньше 3");
        this.name = name;
        setPrincipal(principal);
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public void dayAtSchool() {
        principal.startLearning();
        lessonsStart();
        principal.endLearning();
    }

    private void lessonsStart() {
        for (int i = 0; i < teachers.length; i++) {
            for (int j = 0; j < pupils.length; j++) {
                if (teachers[i].getSchoolSubject().equalsIgnoreCase(pupils[j].getSchoolSubject())) {
                    teachers[i].teach(pupils[j]);
                }
            }
        }
    }
}
