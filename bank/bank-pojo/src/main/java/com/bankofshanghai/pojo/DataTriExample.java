package com.bankofshanghai.pojo;

import java.util.ArrayList;
import java.util.List;

public class DataTriExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataTriExample() {
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

        public Criteria andTri1IsNull() {
            addCriterion("tri_1 is null");
            return (Criteria) this;
        }

        public Criteria andTri1IsNotNull() {
            addCriterion("tri_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTri1EqualTo(Integer value) {
            addCriterion("tri_1 =", value, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1NotEqualTo(Integer value) {
            addCriterion("tri_1 <>", value, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1GreaterThan(Integer value) {
            addCriterion("tri_1 >", value, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_1 >=", value, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1LessThan(Integer value) {
            addCriterion("tri_1 <", value, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1LessThanOrEqualTo(Integer value) {
            addCriterion("tri_1 <=", value, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1In(List<Integer> values) {
            addCriterion("tri_1 in", values, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1NotIn(List<Integer> values) {
            addCriterion("tri_1 not in", values, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1Between(Integer value1, Integer value2) {
            addCriterion("tri_1 between", value1, value2, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri1NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_1 not between", value1, value2, "tri1");
            return (Criteria) this;
        }

        public Criteria andTri2IsNull() {
            addCriterion("tri_2 is null");
            return (Criteria) this;
        }

        public Criteria andTri2IsNotNull() {
            addCriterion("tri_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTri2EqualTo(Integer value) {
            addCriterion("tri_2 =", value, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2NotEqualTo(Integer value) {
            addCriterion("tri_2 <>", value, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2GreaterThan(Integer value) {
            addCriterion("tri_2 >", value, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_2 >=", value, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2LessThan(Integer value) {
            addCriterion("tri_2 <", value, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2LessThanOrEqualTo(Integer value) {
            addCriterion("tri_2 <=", value, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2In(List<Integer> values) {
            addCriterion("tri_2 in", values, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2NotIn(List<Integer> values) {
            addCriterion("tri_2 not in", values, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2Between(Integer value1, Integer value2) {
            addCriterion("tri_2 between", value1, value2, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri2NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_2 not between", value1, value2, "tri2");
            return (Criteria) this;
        }

        public Criteria andTri3IsNull() {
            addCriterion("tri_3 is null");
            return (Criteria) this;
        }

        public Criteria andTri3IsNotNull() {
            addCriterion("tri_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTri3EqualTo(Integer value) {
            addCriterion("tri_3 =", value, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3NotEqualTo(Integer value) {
            addCriterion("tri_3 <>", value, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3GreaterThan(Integer value) {
            addCriterion("tri_3 >", value, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_3 >=", value, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3LessThan(Integer value) {
            addCriterion("tri_3 <", value, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3LessThanOrEqualTo(Integer value) {
            addCriterion("tri_3 <=", value, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3In(List<Integer> values) {
            addCriterion("tri_3 in", values, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3NotIn(List<Integer> values) {
            addCriterion("tri_3 not in", values, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3Between(Integer value1, Integer value2) {
            addCriterion("tri_3 between", value1, value2, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri3NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_3 not between", value1, value2, "tri3");
            return (Criteria) this;
        }

        public Criteria andTri4IsNull() {
            addCriterion("tri_4 is null");
            return (Criteria) this;
        }

        public Criteria andTri4IsNotNull() {
            addCriterion("tri_4 is not null");
            return (Criteria) this;
        }

        public Criteria andTri4EqualTo(Integer value) {
            addCriterion("tri_4 =", value, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4NotEqualTo(Integer value) {
            addCriterion("tri_4 <>", value, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4GreaterThan(Integer value) {
            addCriterion("tri_4 >", value, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_4 >=", value, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4LessThan(Integer value) {
            addCriterion("tri_4 <", value, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4LessThanOrEqualTo(Integer value) {
            addCriterion("tri_4 <=", value, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4In(List<Integer> values) {
            addCriterion("tri_4 in", values, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4NotIn(List<Integer> values) {
            addCriterion("tri_4 not in", values, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4Between(Integer value1, Integer value2) {
            addCriterion("tri_4 between", value1, value2, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri4NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_4 not between", value1, value2, "tri4");
            return (Criteria) this;
        }

        public Criteria andTri5IsNull() {
            addCriterion("tri_5 is null");
            return (Criteria) this;
        }

        public Criteria andTri5IsNotNull() {
            addCriterion("tri_5 is not null");
            return (Criteria) this;
        }

        public Criteria andTri5EqualTo(Integer value) {
            addCriterion("tri_5 =", value, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5NotEqualTo(Integer value) {
            addCriterion("tri_5 <>", value, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5GreaterThan(Integer value) {
            addCriterion("tri_5 >", value, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_5 >=", value, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5LessThan(Integer value) {
            addCriterion("tri_5 <", value, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5LessThanOrEqualTo(Integer value) {
            addCriterion("tri_5 <=", value, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5In(List<Integer> values) {
            addCriterion("tri_5 in", values, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5NotIn(List<Integer> values) {
            addCriterion("tri_5 not in", values, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5Between(Integer value1, Integer value2) {
            addCriterion("tri_5 between", value1, value2, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri5NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_5 not between", value1, value2, "tri5");
            return (Criteria) this;
        }

        public Criteria andTri6IsNull() {
            addCriterion("tri_6 is null");
            return (Criteria) this;
        }

        public Criteria andTri6IsNotNull() {
            addCriterion("tri_6 is not null");
            return (Criteria) this;
        }

        public Criteria andTri6EqualTo(Integer value) {
            addCriterion("tri_6 =", value, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6NotEqualTo(Integer value) {
            addCriterion("tri_6 <>", value, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6GreaterThan(Integer value) {
            addCriterion("tri_6 >", value, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_6 >=", value, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6LessThan(Integer value) {
            addCriterion("tri_6 <", value, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6LessThanOrEqualTo(Integer value) {
            addCriterion("tri_6 <=", value, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6In(List<Integer> values) {
            addCriterion("tri_6 in", values, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6NotIn(List<Integer> values) {
            addCriterion("tri_6 not in", values, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6Between(Integer value1, Integer value2) {
            addCriterion("tri_6 between", value1, value2, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri6NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_6 not between", value1, value2, "tri6");
            return (Criteria) this;
        }

        public Criteria andTri7IsNull() {
            addCriterion("tri_7 is null");
            return (Criteria) this;
        }

        public Criteria andTri7IsNotNull() {
            addCriterion("tri_7 is not null");
            return (Criteria) this;
        }

        public Criteria andTri7EqualTo(Integer value) {
            addCriterion("tri_7 =", value, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7NotEqualTo(Integer value) {
            addCriterion("tri_7 <>", value, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7GreaterThan(Integer value) {
            addCriterion("tri_7 >", value, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_7 >=", value, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7LessThan(Integer value) {
            addCriterion("tri_7 <", value, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7LessThanOrEqualTo(Integer value) {
            addCriterion("tri_7 <=", value, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7In(List<Integer> values) {
            addCriterion("tri_7 in", values, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7NotIn(List<Integer> values) {
            addCriterion("tri_7 not in", values, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7Between(Integer value1, Integer value2) {
            addCriterion("tri_7 between", value1, value2, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri7NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_7 not between", value1, value2, "tri7");
            return (Criteria) this;
        }

        public Criteria andTri8IsNull() {
            addCriterion("tri_8 is null");
            return (Criteria) this;
        }

        public Criteria andTri8IsNotNull() {
            addCriterion("tri_8 is not null");
            return (Criteria) this;
        }

        public Criteria andTri8EqualTo(Integer value) {
            addCriterion("tri_8 =", value, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8NotEqualTo(Integer value) {
            addCriterion("tri_8 <>", value, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8GreaterThan(Integer value) {
            addCriterion("tri_8 >", value, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_8 >=", value, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8LessThan(Integer value) {
            addCriterion("tri_8 <", value, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8LessThanOrEqualTo(Integer value) {
            addCriterion("tri_8 <=", value, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8In(List<Integer> values) {
            addCriterion("tri_8 in", values, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8NotIn(List<Integer> values) {
            addCriterion("tri_8 not in", values, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8Between(Integer value1, Integer value2) {
            addCriterion("tri_8 between", value1, value2, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri8NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_8 not between", value1, value2, "tri8");
            return (Criteria) this;
        }

        public Criteria andTri9IsNull() {
            addCriterion("tri_9 is null");
            return (Criteria) this;
        }

        public Criteria andTri9IsNotNull() {
            addCriterion("tri_9 is not null");
            return (Criteria) this;
        }

        public Criteria andTri9EqualTo(Integer value) {
            addCriterion("tri_9 =", value, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9NotEqualTo(Integer value) {
            addCriterion("tri_9 <>", value, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9GreaterThan(Integer value) {
            addCriterion("tri_9 >", value, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_9 >=", value, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9LessThan(Integer value) {
            addCriterion("tri_9 <", value, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9LessThanOrEqualTo(Integer value) {
            addCriterion("tri_9 <=", value, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9In(List<Integer> values) {
            addCriterion("tri_9 in", values, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9NotIn(List<Integer> values) {
            addCriterion("tri_9 not in", values, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9Between(Integer value1, Integer value2) {
            addCriterion("tri_9 between", value1, value2, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri9NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_9 not between", value1, value2, "tri9");
            return (Criteria) this;
        }

        public Criteria andTri10IsNull() {
            addCriterion("tri_10 is null");
            return (Criteria) this;
        }

        public Criteria andTri10IsNotNull() {
            addCriterion("tri_10 is not null");
            return (Criteria) this;
        }

        public Criteria andTri10EqualTo(Integer value) {
            addCriterion("tri_10 =", value, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10NotEqualTo(Integer value) {
            addCriterion("tri_10 <>", value, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10GreaterThan(Integer value) {
            addCriterion("tri_10 >", value, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_10 >=", value, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10LessThan(Integer value) {
            addCriterion("tri_10 <", value, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10LessThanOrEqualTo(Integer value) {
            addCriterion("tri_10 <=", value, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10In(List<Integer> values) {
            addCriterion("tri_10 in", values, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10NotIn(List<Integer> values) {
            addCriterion("tri_10 not in", values, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10Between(Integer value1, Integer value2) {
            addCriterion("tri_10 between", value1, value2, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri10NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_10 not between", value1, value2, "tri10");
            return (Criteria) this;
        }

        public Criteria andTri11IsNull() {
            addCriterion("tri_11 is null");
            return (Criteria) this;
        }

        public Criteria andTri11IsNotNull() {
            addCriterion("tri_11 is not null");
            return (Criteria) this;
        }

        public Criteria andTri11EqualTo(Integer value) {
            addCriterion("tri_11 =", value, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11NotEqualTo(Integer value) {
            addCriterion("tri_11 <>", value, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11GreaterThan(Integer value) {
            addCriterion("tri_11 >", value, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_11 >=", value, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11LessThan(Integer value) {
            addCriterion("tri_11 <", value, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11LessThanOrEqualTo(Integer value) {
            addCriterion("tri_11 <=", value, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11In(List<Integer> values) {
            addCriterion("tri_11 in", values, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11NotIn(List<Integer> values) {
            addCriterion("tri_11 not in", values, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11Between(Integer value1, Integer value2) {
            addCriterion("tri_11 between", value1, value2, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri11NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_11 not between", value1, value2, "tri11");
            return (Criteria) this;
        }

        public Criteria andTri12IsNull() {
            addCriterion("tri_12 is null");
            return (Criteria) this;
        }

        public Criteria andTri12IsNotNull() {
            addCriterion("tri_12 is not null");
            return (Criteria) this;
        }

        public Criteria andTri12EqualTo(Integer value) {
            addCriterion("tri_12 =", value, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12NotEqualTo(Integer value) {
            addCriterion("tri_12 <>", value, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12GreaterThan(Integer value) {
            addCriterion("tri_12 >", value, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12GreaterThanOrEqualTo(Integer value) {
            addCriterion("tri_12 >=", value, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12LessThan(Integer value) {
            addCriterion("tri_12 <", value, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12LessThanOrEqualTo(Integer value) {
            addCriterion("tri_12 <=", value, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12In(List<Integer> values) {
            addCriterion("tri_12 in", values, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12NotIn(List<Integer> values) {
            addCriterion("tri_12 not in", values, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12Between(Integer value1, Integer value2) {
            addCriterion("tri_12 between", value1, value2, "tri12");
            return (Criteria) this;
        }

        public Criteria andTri12NotBetween(Integer value1, Integer value2) {
            addCriterion("tri_12 not between", value1, value2, "tri12");
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