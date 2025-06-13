public class MVCTest {
    public static void main(String[] args) {
        Student model = new Student();
        model.setName("Ram");
        model.setId("CSE2025001");
        model.setGrade("A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        System.out.println("\nUpdating student grade to B+...\n");

        controller.setStudentGrade("B+");

        controller.updateView();
    }
}
