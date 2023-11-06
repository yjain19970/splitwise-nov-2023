package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "user_group")
@Getter
@Setter
public class Group extends BaseModel {
    private String name;

    @ManyToMany
    private List<User> members;

    @OneToMany(mappedBy = "group") // mapped by {} attribute in {other (Expense)} class
    private List<Expense> expenses;

    @ManyToOne
    private User createdBy;
}
