package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.domain.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity()
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sander_id")
    private Users sender;

    @ManyToOne
    @JoinColumn(name = "reciver_id")
    private Users reciver;

    private LocalDateTime timestamp;










}
