import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            if (StudentsCount == 0) {
                stat.setAvgExamScore(BigDecimal.valueOf(0));
            }else{
                MathContext context = new MathContext(3, RoundingMode.HALF_UP);
                BigDecimal result = new BigDecimal(Score / StudentsCount, context);
                stat.setAvgExamScore(result);
            }
            stat.setStudyProfile(university.getMainProfile());
            stat.setUniversityName(university.getFullName());
            stats.add(stat);
        }

        return stats;
    }

}
