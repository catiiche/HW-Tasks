package com.ifmo.jjd.Lesson8.Homework8School;

public class App {
    public static void main(String[] args) {
        Principal principal = new Principal("Leonid Sergeevich", 45, "Math");
        principal.setSchoolSubject("Geo");
        School school = new School("School 18", principal);

        Pupils pup1 = new Pupils("Vasya", 12, "Math");
        Pupils pup2 = new Pupils("Sidr", 12, "Phys");
        Pupils pup3 = new Pupils("Ira", 13, "Geo");

        Teachers teacher1 = new Teachers("Irina Ivanovna", 68, "Phys");
        Teachers teacher2 = new Teachers("Natalia Petrovna", 69, "Math");
        Teachers teacher3 = new Teachers("Zinaida Grigorievna", 58, "Geo");
        Teachers teacher4 = new Teachers("Olga Ivanovna", 45, "Geo");

        Pupils[] pupils = {pup1, pup2, pup3};
        Teachers[] teachers = {teacher1, teacher2, teacher3, teacher4, principal};

        school.pupils = pupils;
        school.teachers = teachers;

        school.dayAtSchool();
        System.out.println(pup3.knowledgeLevel); //проверяем как изменился уровень знаний у третьего ученика
    }
}
