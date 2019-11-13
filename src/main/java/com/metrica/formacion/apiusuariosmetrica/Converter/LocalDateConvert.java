package com.metrica.formacion.apiusuariosmetrica.Converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateConvert implements AttributeConverter<LocalDate, Date> {


    @Override
    public Date convertToDatabaseColumn(LocalDate localDateTime) {
        return Date.valueOf(localDateTime );
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date.toLocalDate();
    }
}
