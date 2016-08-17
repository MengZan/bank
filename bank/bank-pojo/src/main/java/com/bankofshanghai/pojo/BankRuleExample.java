package com.bankofshanghai.pojo;

import java.util.ArrayList;
import java.util.List;

public class BankRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankRuleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRulenameIsNull() {
            addCriterion("rulename is null");
            return (Criteria) this;
        }

        public Criteria andRulenameIsNotNull() {
            addCriterion("rulename is not null");
            return (Criteria) this;
        }

        public Criteria andRulenameEqualTo(String value) {
            addCriterion("rulename =", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotEqualTo(String value) {
            addCriterion("rulename <>", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameGreaterThan(String value) {
            addCriterion("rulename >", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameGreaterThanOrEqualTo(String value) {
            addCriterion("rulename >=", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLessThan(String value) {
            addCriterion("rulename <", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLessThanOrEqualTo(String value) {
            addCriterion("rulename <=", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameLike(String value) {
            addCriterion("rulename like", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotLike(String value) {
            addCriterion("rulename not like", value, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameIn(List<String> values) {
            addCriterion("rulename in", values, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotIn(List<String> values) {
            addCriterion("rulename not in", values, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameBetween(String value1, String value2) {
            addCriterion("rulename between", value1, value2, "rulename");
            return (Criteria) this;
        }

        public Criteria andRulenameNotBetween(String value1, String value2) {
            addCriterion("rulename not between", value1, value2, "rulename");
            return (Criteria) this;
        }

        public Criteria andRuledescIsNull() {
            addCriterion("ruledesc is null");
            return (Criteria) this;
        }

        public Criteria andRuledescIsNotNull() {
            addCriterion("ruledesc is not null");
            return (Criteria) this;
        }

        public Criteria andRuledescEqualTo(String value) {
            addCriterion("ruledesc =", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescNotEqualTo(String value) {
            addCriterion("ruledesc <>", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescGreaterThan(String value) {
            addCriterion("ruledesc >", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescGreaterThanOrEqualTo(String value) {
            addCriterion("ruledesc >=", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescLessThan(String value) {
            addCriterion("ruledesc <", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescLessThanOrEqualTo(String value) {
            addCriterion("ruledesc <=", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescLike(String value) {
            addCriterion("ruledesc like", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescNotLike(String value) {
            addCriterion("ruledesc not like", value, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescIn(List<String> values) {
            addCriterion("ruledesc in", values, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescNotIn(List<String> values) {
            addCriterion("ruledesc not in", values, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescBetween(String value1, String value2) {
            addCriterion("ruledesc between", value1, value2, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andRuledescNotBetween(String value1, String value2) {
            addCriterion("ruledesc not between", value1, value2, "ruledesc");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Long value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Long value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Long value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Long value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Long value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Long value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Long> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Long> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Long value1, Long value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Long value1, Long value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSafeLevelIsNull() {
            addCriterion("safe_level is null");
            return (Criteria) this;
        }

        public Criteria andSafeLevelIsNotNull() {
            addCriterion("safe_level is not null");
            return (Criteria) this;
        }

        public Criteria andSafeLevelEqualTo(Integer value) {
            addCriterion("safe_level =", value, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelNotEqualTo(Integer value) {
            addCriterion("safe_level <>", value, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelGreaterThan(Integer value) {
            addCriterion("safe_level >", value, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("safe_level >=", value, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelLessThan(Integer value) {
            addCriterion("safe_level <", value, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelLessThanOrEqualTo(Integer value) {
            addCriterion("safe_level <=", value, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelIn(List<Integer> values) {
            addCriterion("safe_level in", values, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelNotIn(List<Integer> values) {
            addCriterion("safe_level not in", values, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelBetween(Integer value1, Integer value2) {
            addCriterion("safe_level between", value1, value2, "safeLevel");
            return (Criteria) this;
        }

        public Criteria andSafeLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("safe_level not between", value1, value2, "safeLevel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}