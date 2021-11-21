public enum StudyProfile {
    MEDICINE ("Medicine"),
    PHYSICS ("PHYSICS"),
    MATHEMATICS ("MATHEMATICS"),
    IT ("IT"),
    LAW ("LAW"),
    SPORT ("SPORT"),
    LINGUISTICS ("LINGUISTICS");


    private String title;

    StudyProfile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
