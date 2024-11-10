package com.fight.model;
import java.util.ArrayList;
import java.util.List;
public class HospitalNeedInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public HospitalNeedInfoExample() {
        oredCriteria = new ArrayList<>();
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
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    public int getStartRow() {
        return startRow;
    }
    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }
    public int getPageRows() {
        return pageRows;
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
            criteria = new ArrayList<>();
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
  public Criteria andIdIsNotNull(){
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
		  addCriterion("id >=", value, "Id");
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
    public Criteria andIdLike(Integer value) {
		  addCriterion("id like", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotLike(Integer value) {
		  addCriterion("id not like", value, "id");
		return (Criteria) this;
		}
 public Criteria andCreateTimeIsNull() {
		 addCriterion("create_time is null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeIsNotNull(){
		addCriterion("create_time is not null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeEqualTo(String value) {
		  addCriterion("create_time =", value, "createTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeNotEqualTo(String value) {
		  addCriterion("create_time <>", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeGreaterThan(String value) {
		 addCriterion("create_time >", value, "createTime");
		return (Criteria) this;
		}
  public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("create_time >=", value, "CreateTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeLessThan(String value) {
		  addCriterion("create_time <", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLessThanOrEqualTo(String value) {
		  addCriterion("create_time <=", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeIn(List<String> values) {
		  addCriterion("create_time in", values, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotIn(List<String> values) {
		  addCriterion("create_time not in", values, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeBetween(String value1, String value2) {
		   addCriterion("create_time between", value1, value2, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeNotBetween(String value1, String value2) {
		   addCriterion("create_time not between", value1, value2, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLike(String value) {
		  addCriterion("create_time like", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotLike(String value) {
		  addCriterion("create_time not like", value, "createTime");
		return (Criteria) this;
		}
 public Criteria andWzTypeIsNull() {
		 addCriterion("wz_type is null");
		return (Criteria) this;
		}
  public Criteria andWzTypeIsNotNull(){
		addCriterion("wz_type is not null");
		return (Criteria) this;
		}
  public Criteria andWzTypeEqualTo(Integer value) {
		  addCriterion("wz_type =", value, "wzType");
		return (Criteria) this;
		}
   public Criteria andWzTypeNotEqualTo(Integer value) {
		  addCriterion("wz_type <>", value, "wzType");
		return (Criteria) this;
		}
    public Criteria andWzTypeGreaterThan(Integer value) {
		 addCriterion("wz_type >", value, "wzType");
		return (Criteria) this;
		}
  public Criteria andWzTypeGreaterThanOrEqualTo(Integer value) {
		  addCriterion("wz_type >=", value, "WzType");
		return (Criteria) this;
		}
   public Criteria andWzTypeLessThan(Integer value) {
		  addCriterion("wz_type <", value, "wzType");
		return (Criteria) this;
		}
    public Criteria andWzTypeLessThanOrEqualTo(Integer value) {
		  addCriterion("wz_type <=", value, "wzType");
		return (Criteria) this;
		}
    public Criteria andWzTypeIn(List<Integer> values) {
		  addCriterion("wz_type in", values, "wzType");
		return (Criteria) this;
		}
    public Criteria andWzTypeNotIn(List<Integer> values) {
		  addCriterion("wz_type not in", values, "wzType");
		return (Criteria) this;
		}
     public Criteria andWzTypeBetween(Integer value1, Integer value2) {
		   addCriterion("wz_type between", value1, value2, "wzType");
		return (Criteria) this;
		}
     public Criteria andWzTypeNotBetween(Integer value1, Integer value2) {
		   addCriterion("wz_type not between", value1, value2, "wzType");
		return (Criteria) this;
		}
    public Criteria andWzTypeLike(Integer value) {
		  addCriterion("wz_type like", value, "wzType");
		return (Criteria) this;
		}
    public Criteria andWzTypeNotLike(Integer value) {
		  addCriterion("wz_type not like", value, "wzType");
		return (Criteria) this;
		}
 public Criteria andWzNameIsNull() {
		 addCriterion("wz_name is null");
		return (Criteria) this;
		}
  public Criteria andWzNameIsNotNull(){
		addCriterion("wz_name is not null");
		return (Criteria) this;
		}
  public Criteria andWzNameEqualTo(String value) {
		  addCriterion("wz_name =", value, "wzName");
		return (Criteria) this;
		}
   public Criteria andWzNameNotEqualTo(String value) {
		  addCriterion("wz_name <>", value, "wzName");
		return (Criteria) this;
		}
    public Criteria andWzNameGreaterThan(String value) {
		 addCriterion("wz_name >", value, "wzName");
		return (Criteria) this;
		}
  public Criteria andWzNameGreaterThanOrEqualTo(String value) {
		  addCriterion("wz_name >=", value, "WzName");
		return (Criteria) this;
		}
   public Criteria andWzNameLessThan(String value) {
		  addCriterion("wz_name <", value, "wzName");
		return (Criteria) this;
		}
    public Criteria andWzNameLessThanOrEqualTo(String value) {
		  addCriterion("wz_name <=", value, "wzName");
		return (Criteria) this;
		}
    public Criteria andWzNameIn(List<String> values) {
		  addCriterion("wz_name in", values, "wzName");
		return (Criteria) this;
		}
    public Criteria andWzNameNotIn(List<String> values) {
		  addCriterion("wz_name not in", values, "wzName");
		return (Criteria) this;
		}
     public Criteria andWzNameBetween(String value1, String value2) {
		   addCriterion("wz_name between", value1, value2, "wzName");
		return (Criteria) this;
		}
     public Criteria andWzNameNotBetween(String value1, String value2) {
		   addCriterion("wz_name not between", value1, value2, "wzName");
		return (Criteria) this;
		}
    public Criteria andWzNameLike(String value) {
		  addCriterion("wz_name like", value, "wzName");
		return (Criteria) this;
		}
    public Criteria andWzNameNotLike(String value) {
		  addCriterion("wz_name not like", value, "wzName");
		return (Criteria) this;
		}
 public Criteria andWzNumIsNull() {
		 addCriterion("wz_num is null");
		return (Criteria) this;
		}
  public Criteria andWzNumIsNotNull(){
		addCriterion("wz_num is not null");
		return (Criteria) this;
		}
  public Criteria andWzNumEqualTo(Integer value) {
		  addCriterion("wz_num =", value, "wzNum");
		return (Criteria) this;
		}
   public Criteria andWzNumNotEqualTo(Integer value) {
		  addCriterion("wz_num <>", value, "wzNum");
		return (Criteria) this;
		}
    public Criteria andWzNumGreaterThan(Integer value) {
		 addCriterion("wz_num >", value, "wzNum");
		return (Criteria) this;
		}
  public Criteria andWzNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("wz_num >=", value, "WzNum");
		return (Criteria) this;
		}
   public Criteria andWzNumLessThan(Integer value) {
		  addCriterion("wz_num <", value, "wzNum");
		return (Criteria) this;
		}
    public Criteria andWzNumLessThanOrEqualTo(Integer value) {
		  addCriterion("wz_num <=", value, "wzNum");
		return (Criteria) this;
		}
    public Criteria andWzNumIn(List<Integer> values) {
		  addCriterion("wz_num in", values, "wzNum");
		return (Criteria) this;
		}
    public Criteria andWzNumNotIn(List<Integer> values) {
		  addCriterion("wz_num not in", values, "wzNum");
		return (Criteria) this;
		}
     public Criteria andWzNumBetween(Integer value1, Integer value2) {
		   addCriterion("wz_num between", value1, value2, "wzNum");
		return (Criteria) this;
		}
     public Criteria andWzNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("wz_num not between", value1, value2, "wzNum");
		return (Criteria) this;
		}
    public Criteria andWzNumLike(Integer value) {
		  addCriterion("wz_num like", value, "wzNum");
		return (Criteria) this;
		}
    public Criteria andWzNumNotLike(Integer value) {
		  addCriterion("wz_num not like", value, "wzNum");
		return (Criteria) this;
		}
 public Criteria andRemarkIsNull() {
		 addCriterion("remark is null");
		return (Criteria) this;
		}
  public Criteria andRemarkIsNotNull(){
		addCriterion("remark is not null");
		return (Criteria) this;
		}
  public Criteria andRemarkEqualTo(String value) {
		  addCriterion("remark =", value, "remark");
		return (Criteria) this;
		}
   public Criteria andRemarkNotEqualTo(String value) {
		  addCriterion("remark <>", value, "remark");
		return (Criteria) this;
		}
    public Criteria andRemarkGreaterThan(String value) {
		 addCriterion("remark >", value, "remark");
		return (Criteria) this;
		}
  public Criteria andRemarkGreaterThanOrEqualTo(String value) {
		  addCriterion("remark >=", value, "Remark");
		return (Criteria) this;
		}
   public Criteria andRemarkLessThan(String value) {
		  addCriterion("remark <", value, "remark");
		return (Criteria) this;
		}
    public Criteria andRemarkLessThanOrEqualTo(String value) {
		  addCriterion("remark <=", value, "remark");
		return (Criteria) this;
		}
    public Criteria andRemarkIn(List<String> values) {
		  addCriterion("remark in", values, "remark");
		return (Criteria) this;
		}
    public Criteria andRemarkNotIn(List<String> values) {
		  addCriterion("remark not in", values, "remark");
		return (Criteria) this;
		}
     public Criteria andRemarkBetween(String value1, String value2) {
		   addCriterion("remark between", value1, value2, "remark");
		return (Criteria) this;
		}
     public Criteria andRemarkNotBetween(String value1, String value2) {
		   addCriterion("remark not between", value1, value2, "remark");
		return (Criteria) this;
		}
    public Criteria andRemarkLike(String value) {
		  addCriterion("remark like", value, "remark");
		return (Criteria) this;
		}
    public Criteria andRemarkNotLike(String value) {
		  addCriterion("remark not like", value, "remark");
		return (Criteria) this;
		}
 public Criteria andHospitalIdIsNull() {
		 addCriterion("hospital_id is null");
		return (Criteria) this;
		}
  public Criteria andHospitalIdIsNotNull(){
		addCriterion("hospital_id is not null");
		return (Criteria) this;
		}
  public Criteria andHospitalIdEqualTo(Integer value) {
		  addCriterion("hospital_id =", value, "hospitalId");
		return (Criteria) this;
		}
   public Criteria andHospitalIdNotEqualTo(Integer value) {
		  addCriterion("hospital_id <>", value, "hospitalId");
		return (Criteria) this;
		}
    public Criteria andHospitalIdGreaterThan(Integer value) {
		 addCriterion("hospital_id >", value, "hospitalId");
		return (Criteria) this;
		}
  public Criteria andHospitalIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("hospital_id >=", value, "HospitalId");
		return (Criteria) this;
		}
   public Criteria andHospitalIdLessThan(Integer value) {
		  addCriterion("hospital_id <", value, "hospitalId");
		return (Criteria) this;
		}
    public Criteria andHospitalIdLessThanOrEqualTo(Integer value) {
		  addCriterion("hospital_id <=", value, "hospitalId");
		return (Criteria) this;
		}
    public Criteria andHospitalIdIn(List<Integer> values) {
		  addCriterion("hospital_id in", values, "hospitalId");
		return (Criteria) this;
		}
    public Criteria andHospitalIdNotIn(List<Integer> values) {
		  addCriterion("hospital_id not in", values, "hospitalId");
		return (Criteria) this;
		}
     public Criteria andHospitalIdBetween(Integer value1, Integer value2) {
		   addCriterion("hospital_id between", value1, value2, "hospitalId");
		return (Criteria) this;
		}
     public Criteria andHospitalIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("hospital_id not between", value1, value2, "hospitalId");
		return (Criteria) this;
		}
    public Criteria andHospitalIdLike(Integer value) {
		  addCriterion("hospital_id like", value, "hospitalId");
		return (Criteria) this;
		}
    public Criteria andHospitalIdNotLike(Integer value) {
		  addCriterion("hospital_id not like", value, "hospitalId");
		return (Criteria) this;
		}
 public Criteria andCompleteNumIsNull() {
		 addCriterion("complete_num is null");
		return (Criteria) this;
		}
  public Criteria andCompleteNumIsNotNull(){
		addCriterion("complete_num is not null");
		return (Criteria) this;
		}
  public Criteria andCompleteNumEqualTo(Integer value) {
		  addCriterion("complete_num =", value, "completeNum");
		return (Criteria) this;
		}
   public Criteria andCompleteNumNotEqualTo(Integer value) {
		  addCriterion("complete_num <>", value, "completeNum");
		return (Criteria) this;
		}
    public Criteria andCompleteNumGreaterThan(Integer value) {
		 addCriterion("complete_num >", value, "completeNum");
		return (Criteria) this;
		}
  public Criteria andCompleteNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("complete_num >=", value, "CompleteNum");
		return (Criteria) this;
		}
   public Criteria andCompleteNumLessThan(Integer value) {
		  addCriterion("complete_num <", value, "completeNum");
		return (Criteria) this;
		}
    public Criteria andCompleteNumLessThanOrEqualTo(Integer value) {
		  addCriterion("complete_num <=", value, "completeNum");
		return (Criteria) this;
		}
    public Criteria andCompleteNumIn(List<Integer> values) {
		  addCriterion("complete_num in", values, "completeNum");
		return (Criteria) this;
		}
    public Criteria andCompleteNumNotIn(List<Integer> values) {
		  addCriterion("complete_num not in", values, "completeNum");
		return (Criteria) this;
		}
     public Criteria andCompleteNumBetween(Integer value1, Integer value2) {
		   addCriterion("complete_num between", value1, value2, "completeNum");
		return (Criteria) this;
		}
     public Criteria andCompleteNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("complete_num not between", value1, value2, "completeNum");
		return (Criteria) this;
		}
    public Criteria andCompleteNumLike(Integer value) {
		  addCriterion("complete_num like", value, "completeNum");
		return (Criteria) this;
		}
    public Criteria andCompleteNumNotLike(Integer value) {
		  addCriterion("complete_num not like", value, "completeNum");
		return (Criteria) this;
		}
 public Criteria andNeedStatusIsNull() {
		 addCriterion("need_status is null");
		return (Criteria) this;
		}
  public Criteria andNeedStatusIsNotNull(){
		addCriterion("need_status is not null");
		return (Criteria) this;
		}
  public Criteria andNeedStatusEqualTo(Integer value) {
		  addCriterion("need_status =", value, "needStatus");
		return (Criteria) this;
		}
   public Criteria andNeedStatusNotEqualTo(Integer value) {
		  addCriterion("need_status <>", value, "needStatus");
		return (Criteria) this;
		}
    public Criteria andNeedStatusGreaterThan(Integer value) {
		 addCriterion("need_status >", value, "needStatus");
		return (Criteria) this;
		}
  public Criteria andNeedStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("need_status >=", value, "NeedStatus");
		return (Criteria) this;
		}
   public Criteria andNeedStatusLessThan(Integer value) {
		  addCriterion("need_status <", value, "needStatus");
		return (Criteria) this;
		}
    public Criteria andNeedStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("need_status <=", value, "needStatus");
		return (Criteria) this;
		}
    public Criteria andNeedStatusIn(List<Integer> values) {
		  addCriterion("need_status in", values, "needStatus");
		return (Criteria) this;
		}
    public Criteria andNeedStatusNotIn(List<Integer> values) {
		  addCriterion("need_status not in", values, "needStatus");
		return (Criteria) this;
		}
     public Criteria andNeedStatusBetween(Integer value1, Integer value2) {
		   addCriterion("need_status between", value1, value2, "needStatus");
		return (Criteria) this;
		}
     public Criteria andNeedStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("need_status not between", value1, value2, "needStatus");
		return (Criteria) this;
		}
    public Criteria andNeedStatusLike(Integer value) {
		  addCriterion("need_status like", value, "needStatus");
		return (Criteria) this;
		}
    public Criteria andNeedStatusNotLike(Integer value) {
		  addCriterion("need_status not like", value, "needStatus");
		return (Criteria) this;
		}
 public Criteria andAddressIsNull() {
		 addCriterion("address is null");
		return (Criteria) this;
		}
  public Criteria andAddressIsNotNull(){
		addCriterion("address is not null");
		return (Criteria) this;
		}
  public Criteria andAddressEqualTo(String value) {
		  addCriterion("address =", value, "address");
		return (Criteria) this;
		}
   public Criteria andAddressNotEqualTo(String value) {
		  addCriterion("address <>", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressGreaterThan(String value) {
		 addCriterion("address >", value, "address");
		return (Criteria) this;
		}
  public Criteria andAddressGreaterThanOrEqualTo(String value) {
		  addCriterion("address >=", value, "Address");
		return (Criteria) this;
		}
   public Criteria andAddressLessThan(String value) {
		  addCriterion("address <", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressLessThanOrEqualTo(String value) {
		  addCriterion("address <=", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressIn(List<String> values) {
		  addCriterion("address in", values, "address");
		return (Criteria) this;
		}
    public Criteria andAddressNotIn(List<String> values) {
		  addCriterion("address not in", values, "address");
		return (Criteria) this;
		}
     public Criteria andAddressBetween(String value1, String value2) {
		   addCriterion("address between", value1, value2, "address");
		return (Criteria) this;
		}
     public Criteria andAddressNotBetween(String value1, String value2) {
		   addCriterion("address not between", value1, value2, "address");
		return (Criteria) this;
		}
    public Criteria andAddressLike(String value) {
		  addCriterion("address like", value, "address");
		return (Criteria) this;
		}
    public Criteria andAddressNotLike(String value) {
		  addCriterion("address not like", value, "address");
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
