public class Profession {
    public String name;
    public String profession;

    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }
}

class Pacient extends Profession {
    public Diagnose diagnose = null;

    public Pacient(String name, String profession) {
        super(name, profession);
        this.name = name;
        this.profession = profession;

    }
}

class Doctor extends Profession {

    public Doctor(String name, String profession) {
        super(name, profession);
        this.name = name;
        this.profession = profession;
    }

    public Diagnose heal(Pacient pacient) {
        return pacient.diagnose;
    }

}

class Diagnose {
}


class Teacher extends Profession {
    public Teacher(String name, String profession) {
        super(name, profession);
        this.name = name;
        this.profession = profession;
    }

    public Skill teach(Student student) {
        return student.skill;
    }
}

class Skill {

}

class Student extends Profession {
    public Skill skill = null;

    public Student(String name, String profession) {
        super(name, profession);
        this.name = name;
        this.profession = profession;

    }
}

class Engineer extends Profession {
    public Engineer(String name, String profession) {
        super(name, profession);
        this.name = name;
        this.profession = profession;
    }

    public House build(House house) {
        return house;
    }
}

class House {
}



