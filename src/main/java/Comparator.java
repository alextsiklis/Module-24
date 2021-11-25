import org.apache.poi.ss.formula.functions.T;

public interface Comparator<T> {
        int compare(T a, T b);
}
