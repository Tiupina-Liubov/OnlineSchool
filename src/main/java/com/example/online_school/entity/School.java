package com.example.online_school.entity;

import com.example.online_school.entity.enums.TypeSchool;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * A class representing a school within the system.
 * Класс, представляющий школу в системе.
 */
@Entity
@Getter
@Setter
@Table(name = "schools")
@NoArgsConstructor
public class School {

    /**
     * Unique identifier.
     * Уникальный идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "school_id")
    private UUID id;

    /**
     * The name of the school.
     * Название школы.
     */
    @Column(name = "name")
    private String name;

    /**
     * The link to the school's website.
     * Ссылка на веб-сайт школы.
     */
    @Column(name = "link")
    private String link;

    /**
     * The phone number of the school.
     * Номер телефона школы.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * The address of the school.
     * Адрес школы.
     */
    @Column(name = "address")
    private String address;

    /**
     * The type of the school.
     * Тип школы.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type_schools")
    TypeSchool typeSchool;

    /**
     * Indicates whether the school is currently open.
     * Показывает, открыта ли в настоящее время школа.
     */
    @Column(name = "is_open")
    private Boolean isOpen;

    /**
     * Date and time when the school was created.
     * Дата и время создания школы.
     */
    @Column(name = "create_at")
    private ZonedDateTime createAt;

    /**
     * Date and time when the school was last updated.
     * Дата и время последнего обновления школы.
     */
    @Column(name = "update_at")
    private ZonedDateTime updateAt;

    /**
     * Set of classes associated with the school.
     * Набор классов, связанных с школой.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    Set<Clazz> schoolClazzes;

    /**
     * Equals method for comparing School objects.
     * Метод сравнения объектов школы.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id) && Objects.equals(name, school.name) && Objects.equals(phoneNumber, school.phoneNumber) && typeSchool == school.typeSchool;
    }

    /**
     * Generates the hash code for the School object.
     * Генерация хэш-кода для объекта школы.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, typeSchool);
    }

    /**
     * Returns the string representation of the School object.
     * Возвращает строковое представление объекта школы.
     */
    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", typeSchool=" + typeSchool +
                '}';
    }
}
