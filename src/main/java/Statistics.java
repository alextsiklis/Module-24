import java.math.BigDecimal;

public class Statistics {
    public Statistics() {

    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public BigDecimal getAvgExamScore() {
        return AvgExamScore;
    }

    public void setAvgExamScore(BigDecimal avgExamScore) {
        this.AvgExamScore = avgExamScore;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getStuCount() {
        return stuCount;
    }

    public void setStuCount(int stuCount) {
        this.stuCount = stuCount;
    }

    public Statistics(StudyProfile studyProfile, BigDecimal avgExamScore, String universityName, int stuCount) {
        this.studyProfile = studyProfile;
        this.AvgExamScore = avgExamScore;
        this.universityName = universityName;
        this.stuCount = stuCount;
    }

    public StudyProfile studyProfile;
    public BigDecimal AvgExamScore;
    public String universityName;
    public int stuCount;

}
