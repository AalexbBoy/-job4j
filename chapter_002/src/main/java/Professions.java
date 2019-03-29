
public class Professions {
    String name;
    String prof;
public Professions(){}
    public Professions(String name, String prof) {
        this.name = name;
        this.prof = prof;
    }
}

 class Teachers extends Professions {
    public Teachers(String name, String prof) {
        super( name,  prof);
    }
}