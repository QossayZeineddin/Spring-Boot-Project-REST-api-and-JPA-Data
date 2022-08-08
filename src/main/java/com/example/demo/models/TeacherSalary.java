package com.example.demo.models;

import javax.persistence.*;

@Entity
public class TeacherSalary {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "salary_id" , nullable = false)
    private  Integer salary_id;

    @Column(name = "amount")
    private Long  amount;

    @Column(name = "raise")
    private Integer raise;

    @Column(name = "total_salary")
    private  Integer total_salary;

    public TeacherSalary() {
        super();
    }

    public TeacherSalary(Integer salary_id, Long amount, Integer raise, Integer total_salary) {
        this.salary_id = salary_id;
        this.amount = amount;
        this.raise = raise;
        this.total_salary = total_salary;
    }

    public Integer getSalary_id() {
        return salary_id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getRaise() {
        return raise;
    }

    public void setRaise(Integer raise) {
        if (raise > 0 && raise <=100) {
            this.raise = raise;
        }else {
            this.raise = 0;
        }
    }

    public Integer getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary() {
        this.total_salary = Math.toIntExact(this.amount + (this.amount * this.raise));
    }

    @Override
    public String toString() {
        return "TeacherSalary{" +
                "salary_id=" + salary_id +
                ", amount=" + amount +
                ", raise=" + raise +
                ", total_salary=" + total_salary +
                '}';
    }
}
