package com.example.online_school.generatorUuid;

import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.util.UUID;

/**
 * Custom UUID generator that combines the current time in milliseconds with a random UUID.
 *
 * Пользовательский генератор UUID, который комбинирует текущее время в миллисекундах с случайным UUID.
 */
@RequiredArgsConstructor
public class UuidTimeSequenceGenerator implements IdentifierGenerator {

    /**
     * Generates a UUID based on the current time in milliseconds and a random UUID.
     *
     * Генерирует UUID на основе текущего времени в миллисекундах и случайного UUID.
     *
     * @param session the session from which this generator is being called
     *                сессия, из которой вызывается этот генератор
     * @param object  the entity or entity instance for which the UUID is being generated
     *                сущность или экземпляр сущности, для которой генерируется UUID
     * @return the generated UUID
     *         сгенерированный UUID
     * @throws HibernateException if an error occurs during UUID generation
     *                            если происходит ошибка во время генерации UUID
     */
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        long currTimeMillis = System.currentTimeMillis();

        return concatUUIDAndTime(currTimeMillis, UUID.randomUUID());
    }

    /**
     * Concatenates the current time in milliseconds with the given UUID.
     *
     * Сцепляет текущее время в миллисекундах с указанным UUID.
     *
     * @param currTimeMillis the current time in milliseconds
     *                       текущее время в миллисекундах
     * @param uuid           the UUID to concatenate
     *                       UUID для конкатенации
     * @return the concatenated UUID
     *         сцепленный UUID
     */
    private UUID concatUUIDAndTime(long currTimeMillis, UUID uuid) {
        String millisHex = Long.toHexString(currTimeMillis);
        String uuidStr = uuid.toString().replace("-", "").substring(0, 16);
        String concatenated = String.format("%016x%s", Long.parseLong(millisHex, 16), uuidStr);

        String concatenatedWithDashes = concatenated.substring(0, 8) + "-" +
                concatenated.substring(8, 12) + "-" +
                concatenated.substring(12, 16) + "-" +
                concatenated.substring(16, 20) + "-" +
                concatenated.substring(20);

        return UUID.fromString(concatenatedWithDashes);
    }
}
