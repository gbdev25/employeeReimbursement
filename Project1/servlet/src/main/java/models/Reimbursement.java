package models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private String description;
	@ManyToOne
    @JoinColumn(name = "authorUsername")
	private User authorUsername;
	@ManyToOne
    @JoinColumn(name = "resolverUsername")
	private User resolverUsername;
	private ReimbursementStatus status;
	private ReimbursementType type;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(User authorUsername) {
		this.authorUsername = authorUsername;
	}

	public User getResolverUsername() {
		return resolverUsername;
	}

	public void setResolverUsername(User resolverUsername) {
		this.resolverUsername = resolverUsername;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, authorUsername, description, id, resolverUsername, status, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return amount == other.amount && Objects.equals(authorUsername, other.authorUsername)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(resolverUsername, other.resolverUsername) && Objects.equals(status, other.status)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", authorUsername="
				+ authorUsername + ", resolverUsername=" + resolverUsername + ", status=" + status + ", type=" + type
				+ "]";
	}
	
	

}
