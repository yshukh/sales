package com.check.sales.entity.converter;

import com.check.sales.entity.attribute.AmountType;

import javax.persistence.AttributeConverter;

public class AmountTypeAttributeConverter implements AttributeConverter<AmountType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AmountType amountType) {
        if (amountType == null) {
            return null;
        }
        switch (amountType) {
            case PIECE:
                return 1;
            case WEIGHT:
                return 2;
            default:
                return 1;
        }
    }

    @Override
    public AmountType convertToEntityAttribute(Integer amountType) {
        if (amountType == null) {
            return null;
        }
        switch (amountType) {
            case 1:
                return AmountType.PIECE;
            case 2:
                return AmountType.WEIGHT;
            default:
                return AmountType.PIECE;
        }
    }

}
