import java.util.ArrayList;
import java.util.List;

public class Transformer {
    public static List<Statistics> former(List<University> universities, List<Student> students) {
        List<Statistics> stats = new ArrayList<>();
        int StudentsCount = 0;
        double Score = 0;
        for (University university : universities) {
            Statistics stat = new Statistics();
            StudentsCount = 0;
            Score = 0;
            for (Student student : students) {
                if (university.getId() == student.getUniversityId()) {
                    StudentsCount++;
                    Score += student.getAvgExamScore();
                }
            }
            stat.setStuCount(StudentsCount);
            stat.setAvgExamScore(Score/StudentsCount);
            stat.setStudyProfile(university.getMainProfile());
            stat.setUniversityName(university.getFullName());
            stats.add(stat);
        }
        return stats;
    }

}
