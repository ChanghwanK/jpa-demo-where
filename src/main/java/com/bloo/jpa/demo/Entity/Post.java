package com.bloo.jpa.demo.Entity;

import com.bloo.jpa.demo.enumclass.PostStatus;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/26
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Where(clause = "status = 'REGISTER'")
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

}
