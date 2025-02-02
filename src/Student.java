public class Student extends Person
{
    private int grade;
    public Student(String firstName, String lastName, String phoneNumber, int grade)
    {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    public int getGrade()
    {
        return grade;
    }
    // Overrides the Person toString to print the grade of the student as well
    @Override
    public String toString()
    {
        // Uses the person toString for code fluency
        return super.toString() + " Grade: " + grade;
    }
}
