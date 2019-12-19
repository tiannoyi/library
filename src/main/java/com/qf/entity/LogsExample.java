package com.qf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogsExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andOpeActionIsNull() {
            addCriterion("ope_action is null");
            return (Criteria) this;
        }

        public Criteria andOpeActionIsNotNull() {
            addCriterion("ope_action is not null");
            return (Criteria) this;
        }

        public Criteria andOpeActionEqualTo(String value) {
            addCriterion("ope_action =", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionNotEqualTo(String value) {
            addCriterion("ope_action <>", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionGreaterThan(String value) {
            addCriterion("ope_action >", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionGreaterThanOrEqualTo(String value) {
            addCriterion("ope_action >=", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionLessThan(String value) {
            addCriterion("ope_action <", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionLessThanOrEqualTo(String value) {
            addCriterion("ope_action <=", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionLike(String value) {
            addCriterion("ope_action like", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionNotLike(String value) {
            addCriterion("ope_action not like", value, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionIn(List<String> values) {
            addCriterion("ope_action in", values, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionNotIn(List<String> values) {
            addCriterion("ope_action not in", values, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionBetween(String value1, String value2) {
            addCriterion("ope_action between", value1, value2, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeActionNotBetween(String value1, String value2) {
            addCriterion("ope_action not between", value1, value2, "opeAction");
            return (Criteria) this;
        }

        public Criteria andOpeEntityIsNull() {
            addCriterion("ope_entity is null");
            return (Criteria) this;
        }

        public Criteria andOpeEntityIsNotNull() {
            addCriterion("ope_entity is not null");
            return (Criteria) this;
        }

        public Criteria andOpeEntityEqualTo(String value) {
            addCriterion("ope_entity =", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityNotEqualTo(String value) {
            addCriterion("ope_entity <>", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityGreaterThan(String value) {
            addCriterion("ope_entity >", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityGreaterThanOrEqualTo(String value) {
            addCriterion("ope_entity >=", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityLessThan(String value) {
            addCriterion("ope_entity <", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityLessThanOrEqualTo(String value) {
            addCriterion("ope_entity <=", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityLike(String value) {
            addCriterion("ope_entity like", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityNotLike(String value) {
            addCriterion("ope_entity not like", value, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityIn(List<String> values) {
            addCriterion("ope_entity in", values, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityNotIn(List<String> values) {
            addCriterion("ope_entity not in", values, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityBetween(String value1, String value2) {
            addCriterion("ope_entity between", value1, value2, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeEntityNotBetween(String value1, String value2) {
            addCriterion("ope_entity not between", value1, value2, "opeEntity");
            return (Criteria) this;
        }

        public Criteria andOpeDetailIsNull() {
            addCriterion("ope_detail is null");
            return (Criteria) this;
        }

        public Criteria andOpeDetailIsNotNull() {
            addCriterion("ope_detail is not null");
            return (Criteria) this;
        }

        public Criteria andOpeDetailEqualTo(String value) {
            addCriterion("ope_detail =", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailNotEqualTo(String value) {
            addCriterion("ope_detail <>", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailGreaterThan(String value) {
            addCriterion("ope_detail >", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailGreaterThanOrEqualTo(String value) {
            addCriterion("ope_detail >=", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailLessThan(String value) {
            addCriterion("ope_detail <", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailLessThanOrEqualTo(String value) {
            addCriterion("ope_detail <=", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailLike(String value) {
            addCriterion("ope_detail like", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailNotLike(String value) {
            addCriterion("ope_detail not like", value, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailIn(List<String> values) {
            addCriterion("ope_detail in", values, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailNotIn(List<String> values) {
            addCriterion("ope_detail not in", values, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailBetween(String value1, String value2) {
            addCriterion("ope_detail between", value1, value2, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andOpeDetailNotBetween(String value1, String value2) {
            addCriterion("ope_detail not between", value1, value2, "opeDetail");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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