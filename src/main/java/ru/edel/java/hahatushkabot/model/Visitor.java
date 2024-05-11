package ru.edel.java.hahatushkabot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@AllArgsConstructor //Генерируем конструктор с параметрами
@NoArgsConstructor //Генерируем конструктор без параметров
@Getter //Генерируем геттеры
@Setter //Генерируем сеттеры
@Entity //Объявляем класс как сущность для работы с ним в БД и его имя
@Table(name = "visitors")

public class Visitor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_generator")
    @SequenceGenerator(name="your_sequence_generator", sequenceName="your_sequence_name", allocationSize=1)
    private Long id;

    @Column(name = "visitor_id")
    private Long visitorId;

    @Column(name = "date")
    private Date date;

    @Column(name = "joke")
    private String joke;
}
