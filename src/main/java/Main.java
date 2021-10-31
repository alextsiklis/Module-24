import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<University> universities = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        University university1 = new University("1", "High School of Economics", "HSE", 1992, StudyProfile.LAW);
        University university2 = new University("2", "Lomonosov Moscow State University", "MSU", 1755, StudyProfile.ENGINEERING);

        universities.add(university1);
        universities.add(university2);

        Student student1 = new Student("Ivanov Ivan Mihailovich", "2", 2, (float) 3.4);
        Student student2 = new Student("Petrov Vasily Sergeevich", "1", 4, (float) 4.2);

        students.add(student1);
        students.add(student2);

        for (University university: universities){
            System.out.println(university.toString());
        }

        for (Student student: students){
            System.out.println(student.toString());
        }
    }
}