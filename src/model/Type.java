package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPES database table.
 * 
 */
@Entity
@Table(name="TYPES")
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long typeid;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="type")
	private List<Transaction> transactions;

	public Type() {
	}

	public long getTypeid() {
		return this.typeid;
	}

	public void setTypeid(long typeid) {
		this.typeid = typeid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setType(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setType(null);

		return transaction;
	}

}