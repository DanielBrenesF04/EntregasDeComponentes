package com.cenfotec.graphql.graphql.entities;

import lombok.Data;


import javax.persistence.criteria.*;



@Data
public class FilterField {
    private String operator;
    private String value;

    public Predicate generateCriteria(CriteriaBuilder builder, Path field) {
        try {
                int v = Integer.parseInt(value);
                switch (operator) {
                    case "lt": return builder.lt(field, v);
                    case "le": return builder.le(field, v);
                    case "gt": return builder.gt(field, v);
                    case "ge": return builder.ge(field, v);
                    case "eq":
                        Predicate equal = builder.equal(field, v);
                        return equal;
                }
        } catch (NumberFormatException e) {
            switch (operator) {
                case "endsWith": return builder.like((Expression<String>) field, "%" + value);
                case "startsWith": return builder.like((Expression<String>) field, value + "%");
                case "contains": return builder.like((Expression<String>) field, "%" + value + "%");
                case "eq": return builder.equal((Expression<?>) field, value);
            }
        }

        return null;
    }
}

