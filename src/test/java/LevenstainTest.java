import com.example.grant20.models.features.LevenshteinDistance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LevenstainTest {

    @Test
    public void calculateDistance1() {
        String s1 = "строка";
        String s2 = "собака";

        int distance = LevenshteinDistance.calculateDistance(s1, s2);
        Assertions.assertEquals(3, distance);
    }

    @Test
    public void calculateDistance2() {
        String s1 = "строка";
        String s2 = "вафля";

        int distance = LevenshteinDistance.calculateDistance(s1, s2);
        Assertions.assertEquals(6, distance);
    }

    @Test
    public void calculateDistance3() {
        String s1 = "слово";
        String s2 = "слово";

        int distance = LevenshteinDistance.calculateDistance(s1, s2);
        Assertions.assertEquals(0, distance);
    }

    @Test
    public void calculateDistance4() {
        String s1 = "Амурская Level";
        String s2 = "Амурская Leve";

        int distance = LevenshteinDistance.calculateDistance(s1, s2);
        Assertions.assertEquals(1, distance);
    }

    @Test
    public void calculateDistance5() {
        String s1 = "Амурская ";
        String s2 = "Амурская";

        int distance = LevenshteinDistance.calculateDistance(s1, s2);
        Assertions.assertEquals(1, distance);
    }
}
