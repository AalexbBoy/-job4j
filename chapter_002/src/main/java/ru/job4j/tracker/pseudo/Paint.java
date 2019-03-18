package ru.job4j.tracker.pseudo;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}

interface Shape {
    String draw();

}

class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++").append(System.lineSeparator());
        pic.append("+  +").append(System.lineSeparator());
        pic.append("+  +").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        return pic.toString();
    }
}


class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    +  ").append(System.lineSeparator());
        pic.append("  +   + ").append(System.lineSeparator());
        pic.append(" +      +").append(System.lineSeparator());
        pic.append("++++++++++").append(System.lineSeparator());
        return pic.toString();
    }
}

