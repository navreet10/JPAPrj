package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name="Account", schema="ora1")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="accnum")
	private long accnum;
	@Column(name="balance")
	private BigDecimal balance;
	@Column(name="feecharged")
	private BigDecimal feecharged;
	@Column(name="name")
	private String name;

	@Column(name="TYPE")
	private String type;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;

	public Account() {
	}

	public long getAccnum() {
		return this.accnum;
	}

	public void setAccnum(long accnum) {
		this.accnum = accnum;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getFeecharged() {
		return this.feecharged;
	}

	public void setFeecharged(BigDecimal feecharged) {
		this.feecharged = feecharged;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		transaction.setAccount(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setAccount(null);

		return transaction;
	}

}