package dev.moisdutra.LibraryApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.OffsetDateTime;

@Entity
@Table(name = "tb_reserves")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReserveModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private BookModel book;

    @Column(name = "reservedDate")
    private OffsetDateTime reservedDate;

    @Column(name = "returnedDate")
    private OffsetDateTime returnedDate;

    @Column(name = "returnStatus")
    private ReserveStatus returnStatus;

}
