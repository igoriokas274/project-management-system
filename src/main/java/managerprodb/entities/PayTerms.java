package managerprodb.entities;

import javax.persistence.*;

@Embeddable
public class PayTerms {

    @Column(name = "term")
    private Integer term;

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}
