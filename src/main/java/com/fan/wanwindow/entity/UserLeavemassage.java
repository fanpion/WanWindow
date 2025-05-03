package com.fan.wanwindow.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_leavemassage")
public class UserLeavemassage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_index", nullable = false)
    private Integer id;

    @Column(name = "message_name")
    private String messageName;

    @Column(name = "message_content", length = 1024)
    private String messageContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @Column(name = "message_time")
    private Date messageTime;

}