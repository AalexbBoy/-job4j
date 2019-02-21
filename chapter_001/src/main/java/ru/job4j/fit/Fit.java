



package ru.job4j.fit;

/**
 * �ணࠬ�� ���� �����쭮�� ���.
 */
public class Fit {

    /**
     * ������� ��� ��� ��騭�.
     * @param height ����.
     * @return ������� ���.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;

    }

    /**
     * ������� ��� ��� ���騭�.
     * @param height ����.
     * @return ������� ���.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;

    }
}