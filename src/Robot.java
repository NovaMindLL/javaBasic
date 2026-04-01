/**
 * Класс Robot представляет собой простого робота, который может перемещаться
 * по двумерной плоскости и менять направление.
 */
public class Robot {
    // Координата робота по оси X
    int x;
    // Координата робота по оси Y
    int y;
    // Направление робота в градусах (0 - Восток, 90 - Север, 180 - Запад, 270 - Юг)
    int course;

    /**
     * Конструктор для создания нового объекта Robot.
     * @param x Начальная координата X.
     * @param y Начальная координата Y.
     * @param course Начальное направление.
     */
    public Robot(int x, int y, int course) {
        this.x = x;
        this.y = y;
        this.course = course;
    }

    /**
     * Выводит текущие координаты и направление робота в консоль.
     */
    public void printCoordinates() {
        System.out.println("x = " + x + ", y = " + y + ", course = " + course);
    }

    /**
     * Перемещает робота вперед на указанное количество шагов в текущем направлении.
     * @param steps Количество шагов.
     */
    public void forward(int steps) {
        switch (course) {
            case 0: // Восток
                x += steps;
                break;
            case 90: // Север
                y += steps;
                break;
            case 180: // Запад
                x -= steps;
                break;
            case 270: // Юг
                y -= steps;
                break;
        }
    }

    /**
     * Поворачивает робота налево на 90 градусов.
     */
    public void turnLeft() {
        course = (course + 90) % 360;
    }

    /**
     * Поворачивает робота направо на 90 градусов.
     */
    public void turnRight() {
        course = (course - 90 + 360) % 360;
    }

    /**
     * Основной метод для демонстрации работы класса Robot.
     * Создает робота, перемещает его и выводит координаты.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, 0);
        robot.printCoordinates(); // x = 0, y = 0, course = 0

        robot.forward(10);
        robot.printCoordinates(); // x = 10, y = 0, course = 0

        robot.turnLeft();
        robot.forward(5);
        robot.printCoordinates(); // x = 10, y = 5, course = 90

        robot.turnRight();
        robot.turnRight();
        robot.forward(3);
        robot.printCoordinates(); // x = 7, y = 5, course = 270
    }

}
