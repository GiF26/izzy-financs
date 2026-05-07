//package com.github.gif26.izzy_financs.service.utils;
//ainda nao esta pronto para uso
//import com.github.gif26.izzy_financs.model.enums.AccountTypeEnum;
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//
//
//@Converter(autoApply = true)
//public class AccountTypeConverter implements AttributeConverter<AccountTypeEnum, Integer> {
//    @Override
//    public Integer convertToDatabaseColumn(AccountTypeEnum attribute) {
//        return attribute != null ? attribute.getValue() : null;
//    }
//
//    @Override
//    public AccountTypeEnum convertToEntityAttribute(Integer dbData) {
//        return dbData != null ? AccountTypeEnum.fromValue(dbData) : null;
//    }
//}