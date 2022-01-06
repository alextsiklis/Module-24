package entity;

import functions.Comparator;
import org.apache.commons.lang3.StringUtils;

public enum EnumStudent implements Comparator<Student> {
    NAME {
        @Override
        public int compare(Student a, Student b) {
            return StringUtils.compare(a.getFullName(), b.getFullName());
        }
    },

    UNIID {
        @Override
        public int compare(Student a, Student b) {
            return StringUtils.compare(a.getUniversityId(), b.getUniversityId());
        }
    },

    COURSE {
        @Override
        public int compare(Student a, Student b) {
            return Integer.compare(a.getCurrentCourseNumber(), b.getCurrentCourseNumber());
        }
    },

    SCORE {
        @Override
        public int compare(Student a, Student b) {
            return - Float.compare(a.getAvgExamScore(), b.getAvgExamScore());
        }
    };
}