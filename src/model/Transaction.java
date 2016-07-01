package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "TRANSACTION" database table.
 * 
 */
@Entity
@Table(name="\"TRANSACTION\"")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionid;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	private Date curdate;

	private String status;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACCNUM")
	private Account account;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="TYPEID")
	private Type type;

	public Transaction() {
	}

	public long getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getCurdate() {
		return this.curdate;
	}

	public void setCurdate(Date curdate) {
		this.curdate = curdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}