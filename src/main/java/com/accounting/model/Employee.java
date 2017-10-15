package com.accounting.model;

import java.io.Serializable;
import java.util.Date;
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

  @Column(name = "experience", insertable = false)
  private Date experience;
  
  @Column(name = "home_address")
  private String homeAddress;

  @Column(name = "admin", insertable = false)
  private boolean admin;
  
  public Employee() {}

  public Employee(String email, String passwordHash, String fullName, Date birth, String position) {
    this.email = email;
    this.passwordHash = passwordHash;
    this.fullName = fullName;
    this.birth = birth;
    this.position = position;
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

  public Date getExperience() {
    return experience;
  }

  public void setExperience(Date experience) {
    this.experience = experience;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
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
    result = prime * result + ((experience == null) ? 0 : experience.hashCode());
    result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
    result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
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
    if (experience == null) {
      if (other.experience != null) {
        return false;
      }
    } else if (!experience.equals(other.experience)) {
      return false;
    }
    if (fullName == null) {
      if (other.fullName != null) {
        return false;
      }
    } else if (!fullName.equals(other.fullName)) {
      return false;
    }
    if (homeAddress == null) {
      if (other.homeAddress != null) {
        return false;
      }
    } else if (!homeAddress.equals(other.homeAddress)) {
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
    return "Employee [id=" + id + ", email=" + email + ", passwordHash=" + passwordHash
        + ", fullName=" + fullName + ", birth=" + birth + ", position=" + position + ", experience="
        + experience + ", homeAddress=" + homeAddress + ", admin=" + admin + "]";
  }
  
}