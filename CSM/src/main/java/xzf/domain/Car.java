package xzf.domain;

// Generated Jun 3, 2015 3:07:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Car generated by hbm2java
 */
@Entity
@Table(name = "car", catalog = "tm_db")
public class Car implements java.io.Serializable {

	private Integer id;
	private Customer customer;
	private String typeCode;
	private String registerNumber;
	private Date registerDate;
	private Date texdue;
	private String insuranceDetail;
	private String chassis;
	private String remark;
	private Date createDate;
	private List<Images> imageses =  new ArrayList<Images>();

	public Car() {
	}

	public Car(Customer customer, String typeCode, String registerNumber,
			Date registerDate, Date texdue, String insuranceDetail,
			String chassis) {
		this.customer = customer;
		this.typeCode = typeCode;
		this.registerNumber = registerNumber;
		this.registerDate = registerDate;
		this.texdue = texdue;
		this.insuranceDetail = insuranceDetail;
		this.chassis = chassis;
	}

	public Car(Customer customer, String typeCode, String registerNumber,
			Date registerDate, Date texdue, String insuranceDetail,
			String chassis, String remark, Date createDate, List<Images> imageses) {
		this.customer = customer;
		this.typeCode = typeCode;
		this.registerNumber = registerNumber;
		this.registerDate = registerDate;
		this.texdue = texdue;
		this.insuranceDetail = insuranceDetail;
		this.chassis = chassis;
		this.remark = remark;
		this.createDate = createDate;
		this.imageses = imageses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id", nullable = false)
	@JsonBackReference
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "type_code", nullable = false, length = 20)
	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "register_number", nullable = false, length = 20)
	public String getRegisterNumber() {
		return this.registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "register_date", nullable = false, length = 10)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "texdue", nullable = false, length = 10)
	public Date getTexdue() {
		return this.texdue;
	}

	public void setTexdue(Date texdue) {
		this.texdue = texdue;
	}

	@Column(name = "insurance_detail", nullable = false)
	public String getInsuranceDetail() {
		return this.insuranceDetail;
	}

	public void setInsuranceDetail(String insuranceDetail) {
		this.insuranceDetail = insuranceDetail;
	}

	@Column(name = "chassis", nullable = false)
	public String getChassis() {
		return this.chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	@JsonBackReference
	public List<Images> getImageses() {
		return this.imageses;
	}

	public void setImageses(List<Images> imageses) {
		this.imageses = imageses;
	}

}
