package com.example.jpaHibernate.student.infrastructure.controller;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.data.annotation.Id;
import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Properties;


public class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator
{
    
    public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    public static final String VALUE_PREFIX_DEFAULT = "";
    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%d";

    private String numberFormat;
    private String valuePrefix;


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return valuePrefix + String.format(numberFormat, super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
    }

}



