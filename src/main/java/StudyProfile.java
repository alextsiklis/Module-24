public enum StudyProfile {
    MEDICINE ("Medicine"),
    ENGINEERING ("Engineering"),
    IT ("IT"),
    LAW ("Law"),
    SPORT ("Sport");

    private String title;

    StudyProfile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
