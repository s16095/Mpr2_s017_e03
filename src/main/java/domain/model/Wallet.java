package domain.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
	@NamedQuery(name="wallet.id", query="Select w FROM Wallet w WHERE w.id=:id"),
	@NamedQuery(name="wallet.person_id", query="select w FROM Wallet w WHERE w.person.id=:person_Id"),
        @NamedQuery(name="wallet.all", query = "select w from Wallet w")
})
public class Wallet implements IHaveId{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Currency currency;
    private BigDecimal asset;

    @ManyToOne
    private Person person;
    @OneToMany(mappedBy="from")
    private List<History> history;
    
    
    
    public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
