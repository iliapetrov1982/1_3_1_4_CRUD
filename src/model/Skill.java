package model;

public class Skill {
    private Long id;
    private String name;

    public Skill(Long id, String skill) {
        this.id = id;
        this.name = skill;
    }

    public Skill(Long id) {
        this.id = id;
    }

    public Skill() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (id != null) {
            return String.format("%d\t%s",
                    id,
                    name
            );
        } else {
            return "Skill not found";
        }
    }
}
