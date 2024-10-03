package not_project_tesr;

import java.util.Objects;

public class HashCode {

    public int number;

    public HashCode(int number) {
        this.number = number;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCode hashCode = (HashCode) o;
        return number == hashCode.number;//&& Double.compare(hashCode.dNumber, dNumber) == 0 && Objects.equals(string, hashCode.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public static void main(String[] args) {
        HashCode hashCode = new HashCode(15);
        HashCode hashCode1 = new HashCode(12);
        System.out.println(hashCode.equals(hashCode1));


    }
}
