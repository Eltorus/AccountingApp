package com.accounting.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

  private static final long serialVersionUID = -8043746569735508075L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String passwordHash;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "birth", insertable = false)
  private Date birth;

  @Column(name = "position")
  private String position;

  @Column(name = "expirience", insertable = false)
  private Date expirience;

  @Column(name = "admin", insertable = false)
  private boolean admin;

  public Employee() {}

  public Employee(long id, String email, String passwordHash, boolean admin) {
    super();
    this.id = id;
    this.email = email;
    this.passwordHash = passwordHash;
    this.admin = admin;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Date getExpirience() {
    return expirience;
  }

  public void setExpirience(Date expirience) {
    this.expirience = expirience;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (admin ? 1231 : 1237);
    result = prime * result + ((birth == null) ? 0 : birth.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((expirience == null) ? 0 : expirience.hashCode());
    result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
    result = prime * result + ((position == null) ? 0 : position.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee other = (Employee) obj;
    if (admin != other.admin) {
      return false;
    }
    if (birth == null) {
      if (other.birth != null) {
        return false;
      }
    } else if (!birth.equals(other.birth)) {
      return false;
    }
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!email.equals(other.email)) {
      return false;
    }
    if (expirience == null) {
      if (other.expirience != null) {
        return false;
      }
    } else if (!expirience.equals(other.expirience)) {
      return false;
    }
    if (fullName == null) {
      if (other.fullName != null) {
        return false;
      }
    } else if (!fullName.equals(other.fullName)) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (passwordHash == null) {
      if (other.passwordHash != null) {
        return false;
      }
    } else if (!passwordHash.equals(other.passwordHash)) {
      return false;
    }
    if (position == null) {
      if (other.position != null) {
        return false;
      }
    } else if (!position.equals(other.position)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", email=" + email + ", fullName=" + fullName + ", birth=" + birth
        + ", position=" + position + ", expirience=" + expirience + ", admin=" + admin + "]";
  }

}
