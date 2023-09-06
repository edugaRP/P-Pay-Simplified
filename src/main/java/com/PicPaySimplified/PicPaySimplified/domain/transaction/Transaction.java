package com.PicPaySimplified.PicPaySimplified.domain.transaction;

import com.PicPaySimplified.PicPaySimplified.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Transaction {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  long id;

        private BigDecimal  amount;

        @ManyToOne
        @JoinColumn(name = "sender_id")
        private User sender;

        @ManyToOne
        @JoinColumn(name = "receiver_id")
        private User receiver;

        private LocalDateTime date;
}
