package com.qf.entity;

import java.util.ArrayList;
import java.util.List;

public class SystemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemExample() {
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

        public Criteria andSysIdIsNull() {
            addCriterion("sys_id is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("sys_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(Integer value) {
            addCriterion("sys_id =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(Integer value) {
            addCriterion("sys_id <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(Integer value) {
            addCriterion("sys_id >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_id >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(Integer value) {
            addCriterion("sys_id <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_id <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<Integer> values) {
            addCriterion("sys_id in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<Integer> values) {
            addCriterion("sys_id not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_id between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_id not between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNull() {
            addCriterion("sys_name is null");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNotNull() {
            addCriterion("sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysNameEqualTo(String value) {
            addCriterion("sys_name =", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotEqualTo(String value) {
            addCriterion("sys_name <>", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThan(String value) {
            addCriterion("sys_name >", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_name >=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThan(String value) {
            addCriterion("sys_name <", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThanOrEqualTo(String value) {
            addCriterion("sys_name <=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLike(String value) {
            addCriterion("sys_name like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotLike(String value) {
            addCriterion("sys_name not like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameIn(List<String> values) {
            addCriterion("sys_name in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotIn(List<String> values) {
            addCriterion("sys_name not in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameBetween(String value1, String value2) {
            addCriterion("sys_name between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotBetween(String value1, String value2) {
            addCriterion("sys_name not between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysImgIsNull() {
            addCriterion("sys_img is null");
            return (Criteria) this;
        }

        public Criteria andSysImgIsNotNull() {
            addCriterion("sys_img is not null");
            return (Criteria) this;
        }

        public Criteria andSysImgEqualTo(String value) {
            addCriterion("sys_img =", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgNotEqualTo(String value) {
            addCriterion("sys_img <>", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgGreaterThan(String value) {
            addCriterion("sys_img >", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgGreaterThanOrEqualTo(String value) {
            addCriterion("sys_img >=", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgLessThan(String value) {
            addCriterion("sys_img <", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgLessThanOrEqualTo(String value) {
            addCriterion("sys_img <=", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgLike(String value) {
            addCriterion("sys_img like", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgNotLike(String value) {
            addCriterion("sys_img not like", value, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgIn(List<String> values) {
            addCriterion("sys_img in", values, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgNotIn(List<String> values) {
            addCriterion("sys_img not in", values, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgBetween(String value1, String value2) {
            addCriterion("sys_img between", value1, value2, "sysImg");
            return (Criteria) this;
        }

        public Criteria andSysImgNotBetween(String value1, String value2) {
            addCriterion("sys_img not between", value1, value2, "sysImg");
            return (Criteria) this;
        }

        public Criteria andPageLineIsNull() {
            addCriterion("page_line is null");
            return (Criteria) this;
        }

        public Criteria andPageLineIsNotNull() {
            addCriterion("page_line is not null");
            return (Criteria) this;
        }

        public Criteria andPageLineEqualTo(String value) {
            addCriterion("page_line =", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineNotEqualTo(String value) {
            addCriterion("page_line <>", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineGreaterThan(String value) {
            addCriterion("page_line >", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineGreaterThanOrEqualTo(String value) {
            addCriterion("page_line >=", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineLessThan(String value) {
            addCriterion("page_line <", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineLessThanOrEqualTo(String value) {
            addCriterion("page_line <=", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineLike(String value) {
            addCriterion("page_line like", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineNotLike(String value) {
            addCriterion("page_line not like", value, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineIn(List<String> values) {
            addCriterion("page_line in", values, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineNotIn(List<String> values) {
            addCriterion("page_line not in", values, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineBetween(String value1, String value2) {
            addCriterion("page_line between", value1, value2, "pageLine");
            return (Criteria) this;
        }

        public Criteria andPageLineNotBetween(String value1, String value2) {
            addCriterion("page_line not between", value1, value2, "pageLine");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("AppID is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("AppID is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(Integer value) {
            addCriterion("AppID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(Integer value) {
            addCriterion("AppID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(Integer value) {
            addCriterion("AppID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AppID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(Integer value) {
            addCriterion("AppID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(Integer value) {
            addCriterion("AppID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<Integer> values) {
            addCriterion("AppID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<Integer> values) {
            addCriterion("AppID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(Integer value1, Integer value2) {
            addCriterion("AppID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(Integer value1, Integer value2) {
            addCriterion("AppID not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNull() {
            addCriterion("AppSecret is null");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNotNull() {
            addCriterion("AppSecret is not null");
            return (Criteria) this;
        }

        public Criteria andAppsecretEqualTo(String value) {
            addCriterion("AppSecret =", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotEqualTo(String value) {
            addCriterion("AppSecret <>", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThan(String value) {
            addCriterion("AppSecret >", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThanOrEqualTo(String value) {
            addCriterion("AppSecret >=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThan(String value) {
            addCriterion("AppSecret <", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThanOrEqualTo(String value) {
            addCriterion("AppSecret <=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLike(String value) {
            addCriterion("AppSecret like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotLike(String value) {
            addCriterion("AppSecret not like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretIn(List<String> values) {
            addCriterion("AppSecret in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotIn(List<String> values) {
            addCriterion("AppSecret not in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretBetween(String value1, String value2) {
            addCriterion("AppSecret between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotBetween(String value1, String value2) {
            addCriterion("AppSecret not between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andBarNameIsNull() {
            addCriterion("bar_Name is null");
            return (Criteria) this;
        }

        public Criteria andBarNameIsNotNull() {
            addCriterion("bar_Name is not null");
            return (Criteria) this;
        }

        public Criteria andBarNameEqualTo(String value) {
            addCriterion("bar_Name =", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameNotEqualTo(String value) {
            addCriterion("bar_Name <>", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameGreaterThan(String value) {
            addCriterion("bar_Name >", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameGreaterThanOrEqualTo(String value) {
            addCriterion("bar_Name >=", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameLessThan(String value) {
            addCriterion("bar_Name <", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameLessThanOrEqualTo(String value) {
            addCriterion("bar_Name <=", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameLike(String value) {
            addCriterion("bar_Name like", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameNotLike(String value) {
            addCriterion("bar_Name not like", value, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameIn(List<String> values) {
            addCriterion("bar_Name in", values, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameNotIn(List<String> values) {
            addCriterion("bar_Name not in", values, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameBetween(String value1, String value2) {
            addCriterion("bar_Name between", value1, value2, "barName");
            return (Criteria) this;
        }

        public Criteria andBarNameNotBetween(String value1, String value2) {
            addCriterion("bar_Name not between", value1, value2, "barName");
            return (Criteria) this;
        }

        public Criteria andFineIsNull() {
            addCriterion("fine is null");
            return (Criteria) this;
        }

        public Criteria andFineIsNotNull() {
            addCriterion("fine is not null");
            return (Criteria) this;
        }

        public Criteria andFineEqualTo(Float value) {
            addCriterion("fine =", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotEqualTo(Float value) {
            addCriterion("fine <>", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThan(Float value) {
            addCriterion("fine >", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThanOrEqualTo(Float value) {
            addCriterion("fine >=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThan(Float value) {
            addCriterion("fine <", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThanOrEqualTo(Float value) {
            addCriterion("fine <=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineIn(List<Float> values) {
            addCriterion("fine in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotIn(List<Float> values) {
            addCriterion("fine not in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineBetween(Float value1, Float value2) {
            addCriterion("fine between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotBetween(Float value1, Float value2) {
            addCriterion("fine not between", value1, value2, "fine");
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