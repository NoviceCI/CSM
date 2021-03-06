package xzf.domain;

// Generated Jun 3, 2015 3:07:26 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "tm_db")
public class Customer implements java.io.Serializable {

	private Integer id;
	private String name;
	private String lastname;
	private String tel1;
	private String tel2;
	private Set<Car> cars = new HashSet<Car>(0);

	public Customer() {
	}

	public Customer(String name, String lastname, String tel1) {
		this.name = name;
		this.lastname = lastname;
		this.tel1 = tel1;
	}

	public Customer(String name, String lastname, String tel1, String tel2,
			Set<Car> cars) {
		this.name = name;
		this.lastname = lastname;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.cars = cars;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "lastname", nullable = false, length = 50)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "tel1", nullable = false, length = 10)
	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	@Column(name = "tel2", length = 10)
	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}
