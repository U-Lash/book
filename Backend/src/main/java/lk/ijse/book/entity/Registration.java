package lk.ijse.book.entity;

import javax.persistence.*;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regId;
    @OneToOne
    private User user;
    @ManyToOne
    private Book book;

    public Registration() {
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regId=" + regId +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
