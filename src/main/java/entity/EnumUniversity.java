package entity;

import functions.Comparator;
import org.apache.commons.lang3.StringUtils;

public enum EnumUniversity implements Comparator<University> {

    NAME {
        @Override
        public int compare(University a, University b) {
            return StringUtils.compare(a.getFullName(), b.getFullName());
        }
    },

    ID {
        @Override
        public int compare(University a, University b) {
            return StringUtils.compare(a.getId(), b.getId());
        }
    },

    YEAR {
        @Override
        public int compare(University a, University b) {
            return Integer.compare(a.getYearOfFoundation(), b.getYearOfFoundation());
        }
    };
}
