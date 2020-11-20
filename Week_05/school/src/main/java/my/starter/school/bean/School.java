package my.starter.school.bean;

public class School {

    private Klass klass;
    private Student student1;

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    @Override
    public String toString() {
        return "School{" +
                "klass=" + klass +
                ", student1=" + student1 +
                '}';
    }
}
