/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.ac.nust.erp.test.crudjpatest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id")
    , @NamedQuery(name = "Student.findByFname", query = "SELECT s FROM Student s WHERE s.fname = :fname")
    , @NamedQuery(name = "Student.findByLname", query = "SELECT s FROM Student s WHERE s.lname = :lname")
    , @NamedQuery(name = "Student.findBySex", query = "SELECT s FROM Student s WHERE s.sex = :sex")
    , @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentid")
    private List<Course> courseList;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(Integer id, String fname, String lname, String sex, Date dob) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.sex = sex;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zw.ac.nust.erp.test.crudjpatest.entities.Student[ id=" + id + " ]";
    }
    
}
