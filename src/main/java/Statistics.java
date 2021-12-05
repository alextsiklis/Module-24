public class Statistics {
    public Statistics() {

    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public double getAvgExamScore() {
        return AvgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        AvgExamScore = avgExamScore;
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

    public Statistics(StudyProfile studyProfile, int avgExamScore, String universityName, int stuCount) {
        this.studyProfile = studyProfile;
        AvgExamScore = avgExamScore;
        this.universityName = universityName;
        this.stuCount = stuCount;
    }

    public StudyProfile studyProfile;
    public double AvgExamScore;
    public String universityName;
    public int stuCount;

}
