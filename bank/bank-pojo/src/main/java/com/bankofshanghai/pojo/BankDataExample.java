package com.bankofshanghai.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankDataExample() {
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

        public Criteria andFromuserIsNull() {
            addCriterion("fromuser is null");
            return (Criteria) this;
        }

        public Criteria andFromuserIsNotNull() {
            addCriterion("fromuser is not null");
            return (Criteria) this;
        }

        public Criteria andFromuserEqualTo(Integer value) {
            addCriterion("fromuser =", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotEqualTo(Integer value) {
            addCriterion("fromuser <>", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserGreaterThan(Integer value) {
            addCriterion("fromuser >", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("fromuser >=", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLessThan(Integer value) {
            addCriterion("fromuser <", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLessThanOrEqualTo(Integer value) {
            addCriterion("fromuser <=", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserIn(List<Integer> values) {
            addCriterion("fromuser in", values, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotIn(List<Integer> values) {
            addCriterion("fromuser not in", values, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserBetween(Integer value1, Integer value2) {
            addCriterion("fromuser between", value1, value2, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotBetween(Integer value1, Integer value2) {
            addCriterion("fromuser not between", value1, value2, "fromuser");
            return (Criteria) this;
        }

        public Criteria andTouserIsNull() {
            addCriterion("touser is null");
            return (Criteria) this;
        }

        public Criteria andTouserIsNotNull() {
            addCriterion("touser is not null");
            return (Criteria) this;
        }

        public Criteria andTouserEqualTo(Integer value) {
            addCriterion("touser =", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotEqualTo(Integer value) {
            addCriterion("touser <>", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThan(Integer value) {
            addCriterion("touser >", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThanOrEqualTo(Integer value) {
            addCriterion("touser >=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThan(Integer value) {
            addCriterion("touser <", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThanOrEqualTo(Integer value) {
            addCriterion("touser <=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserIn(List<Integer> values) {
            addCriterion("touser in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotIn(List<Integer> values) {
            addCriterion("touser not in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserBetween(Integer value1, Integer value2) {
            addCriterion("touser between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotBetween(Integer value1, Integer value2) {
            addCriterion("touser not between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNull() {
            addCriterion("datetime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("datetime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterion("datetime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterion("datetime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterion("datetime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("datetime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterion("datetime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("datetime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterion("datetime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterion("datetime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterion("datetime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("datetime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andFromplaceIsNull() {
            addCriterion("fromplace is null");
            return (Criteria) this;
        }

        public Criteria andFromplaceIsNotNull() {
            addCriterion("fromplace is not null");
            return (Criteria) this;
        }

        public Criteria andFromplaceEqualTo(String value) {
            addCriterion("fromplace =", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceNotEqualTo(String value) {
            addCriterion("fromplace <>", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceGreaterThan(String value) {
            addCriterion("fromplace >", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceGreaterThanOrEqualTo(String value) {
            addCriterion("fromplace >=", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceLessThan(String value) {
            addCriterion("fromplace <", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceLessThanOrEqualTo(String value) {
            addCriterion("fromplace <=", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceLike(String value) {
            addCriterion("fromplace like", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceNotLike(String value) {
            addCriterion("fromplace not like", value, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceIn(List<String> values) {
            addCriterion("fromplace in", values, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceNotIn(List<String> values) {
            addCriterion("fromplace not in", values, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceBetween(String value1, String value2) {
            addCriterion("fromplace between", value1, value2, "fromplace");
            return (Criteria) this;
        }

        public Criteria andFromplaceNotBetween(String value1, String value2) {
            addCriterion("fromplace not between", value1, value2, "fromplace");
            return (Criteria) this;
        }

        public Criteria andToplaceIsNull() {
            addCriterion("toplace is null");
            return (Criteria) this;
        }

        public Criteria andToplaceIsNotNull() {
            addCriterion("toplace is not null");
            return (Criteria) this;
        }

        public Criteria andToplaceEqualTo(String value) {
            addCriterion("toplace =", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceNotEqualTo(String value) {
            addCriterion("toplace <>", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceGreaterThan(String value) {
            addCriterion("toplace >", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceGreaterThanOrEqualTo(String value) {
            addCriterion("toplace >=", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceLessThan(String value) {
            addCriterion("toplace <", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceLessThanOrEqualTo(String value) {
            addCriterion("toplace <=", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceLike(String value) {
            addCriterion("toplace like", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceNotLike(String value) {
            addCriterion("toplace not like", value, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceIn(List<String> values) {
            addCriterion("toplace in", values, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceNotIn(List<String> values) {
            addCriterion("toplace not in", values, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceBetween(String value1, String value2) {
            addCriterion("toplace between", value1, value2, "toplace");
            return (Criteria) this;
        }

        public Criteria andToplaceNotBetween(String value1, String value2) {
            addCriterion("toplace not between", value1, value2, "toplace");
            return (Criteria) this;
        }

        public Criteria andToolIsNull() {
            addCriterion("tool is null");
            return (Criteria) this;
        }

        public Criteria andToolIsNotNull() {
            addCriterion("tool is not null");
            return (Criteria) this;
        }

        public Criteria andToolEqualTo(String value) {
            addCriterion("tool =", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotEqualTo(String value) {
            addCriterion("tool <>", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolGreaterThan(String value) {
            addCriterion("tool >", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolGreaterThanOrEqualTo(String value) {
            addCriterion("tool >=", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolLessThan(String value) {
            addCriterion("tool <", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolLessThanOrEqualTo(String value) {
            addCriterion("tool <=", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolLike(String value) {
            addCriterion("tool like", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotLike(String value) {
            addCriterion("tool not like", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolIn(List<String> values) {
            addCriterion("tool in", values, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotIn(List<String> values) {
            addCriterion("tool not in", values, "tool");
            return (Criteria) this;
        }

        public Criteria andToolBetween(String value1, String value2) {
            addCriterion("tool between", value1, value2, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotBetween(String value1, String value2) {
            addCriterion("tool not between", value1, value2, "tool");
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