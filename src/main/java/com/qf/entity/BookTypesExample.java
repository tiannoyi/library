package com.qf.entity;

import java.util.ArrayList;
import java.util.List;

public class BookTypesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookTypesExample() {
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

        public Criteria andBookTypeIdIsNull() {
            addCriterion("book_type_id is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdIsNotNull() {
            addCriterion("book_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdEqualTo(Integer value) {
            addCriterion("book_type_id =", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdNotEqualTo(Integer value) {
            addCriterion("book_type_id <>", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdGreaterThan(Integer value) {
            addCriterion("book_type_id >", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_type_id >=", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdLessThan(Integer value) {
            addCriterion("book_type_id <", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_type_id <=", value, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdIn(List<Integer> values) {
            addCriterion("book_type_id in", values, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdNotIn(List<Integer> values) {
            addCriterion("book_type_id not in", values, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("book_type_id between", value1, value2, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_type_id not between", value1, value2, "bookTypeId");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameIsNull() {
            addCriterion("book_type_name is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameIsNotNull() {
            addCriterion("book_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameEqualTo(String value) {
            addCriterion("book_type_name =", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameNotEqualTo(String value) {
            addCriterion("book_type_name <>", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameGreaterThan(String value) {
            addCriterion("book_type_name >", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_type_name >=", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameLessThan(String value) {
            addCriterion("book_type_name <", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameLessThanOrEqualTo(String value) {
            addCriterion("book_type_name <=", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameLike(String value) {
            addCriterion("book_type_name like", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameNotLike(String value) {
            addCriterion("book_type_name not like", value, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameIn(List<String> values) {
            addCriterion("book_type_name in", values, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameNotIn(List<String> values) {
            addCriterion("book_type_name not in", values, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameBetween(String value1, String value2) {
            addCriterion("book_type_name between", value1, value2, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andBookTypeNameNotBetween(String value1, String value2) {
            addCriterion("book_type_name not between", value1, value2, "bookTypeName");
            return (Criteria) this;
        }

        public Criteria andFatherNodeIsNull() {
            addCriterion("father_node is null");
            return (Criteria) this;
        }

        public Criteria andFatherNodeIsNotNull() {
            addCriterion("father_node is not null");
            return (Criteria) this;
        }

        public Criteria andFatherNodeEqualTo(String value) {
            addCriterion("father_node =", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeNotEqualTo(String value) {
            addCriterion("father_node <>", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeGreaterThan(String value) {
            addCriterion("father_node >", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeGreaterThanOrEqualTo(String value) {
            addCriterion("father_node >=", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeLessThan(String value) {
            addCriterion("father_node <", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeLessThanOrEqualTo(String value) {
            addCriterion("father_node <=", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeLike(String value) {
            addCriterion("father_node like", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeNotLike(String value) {
            addCriterion("father_node not like", value, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeIn(List<String> values) {
            addCriterion("father_node in", values, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeNotIn(List<String> values) {
            addCriterion("father_node not in", values, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeBetween(String value1, String value2) {
            addCriterion("father_node between", value1, value2, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andFatherNodeNotBetween(String value1, String value2) {
            addCriterion("father_node not between", value1, value2, "fatherNode");
            return (Criteria) this;
        }

        public Criteria andClassNumberIsNull() {
            addCriterion("class_number is null");
            return (Criteria) this;
        }

        public Criteria andClassNumberIsNotNull() {
            addCriterion("class_number is not null");
            return (Criteria) this;
        }

        public Criteria andClassNumberEqualTo(String value) {
            addCriterion("class_number =", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotEqualTo(String value) {
            addCriterion("class_number <>", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThan(String value) {
            addCriterion("class_number >", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThanOrEqualTo(String value) {
            addCriterion("class_number >=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThan(String value) {
            addCriterion("class_number <", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThanOrEqualTo(String value) {
            addCriterion("class_number <=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLike(String value) {
            addCriterion("class_number like", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotLike(String value) {
            addCriterion("class_number not like", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberIn(List<String> values) {
            addCriterion("class_number in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotIn(List<String> values) {
            addCriterion("class_number not in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberBetween(String value1, String value2) {
            addCriterion("class_number between", value1, value2, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotBetween(String value1, String value2) {
            addCriterion("class_number not between", value1, value2, "classNumber");
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