package com.example.online_school.entity.enums;

import com.example.online_school.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public enum TypeSchool {
    COLLEGE,//колледж
    ELEMENTARY,//начальная школа
    HIGH,// — средняя школа
    JUNIOR_COLLEGE,//колледж с двухгодичным неполным обучением
    JUNIOR_HIGH,// — младшие классы средней школы
    TECHNICAL,//техникум
    UNIVERSITY//университет
}
