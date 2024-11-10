package com.fight.model;
import java.util.ArrayList;
import java.util.List;
public class MjInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public MjInfoExample() {
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
 public Criteria andRealNameIsNull() {
		 addCriterion("real_name is null");
		return (Criteria) this;
		}
  public Criteria andRealNameIsNotNull(){
		addCriterion("real_name is not null");
		return (Criteria) this;
		}
  public Criteria andRealNameEqualTo(String value) {
		  addCriterion("real_name =", value, "realName");
		return (Criteria) this;
		}
   public Criteria andRealNameNotEqualTo(String value) {
		  addCriterion("real_name <>", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameGreaterThan(String value) {
		 addCriterion("real_name >", value, "realName");
		return (Criteria) this;
		}
  public Criteria andRealNameGreaterThanOrEqualTo(String value) {
		  addCriterion("real_name >=", value, "RealName");
		return (Criteria) this;
		}
   public Criteria andRealNameLessThan(String value) {
		  addCriterion("real_name <", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameLessThanOrEqualTo(String value) {
		  addCriterion("real_name <=", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameIn(List<String> values) {
		  addCriterion("real_name in", values, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameNotIn(List<String> values) {
		  addCriterion("real_name not in", values, "realName");
		return (Criteria) this;
		}
     public Criteria andRealNameBetween(String value1, String value2) {
		   addCriterion("real_name between", value1, value2, "realName");
		return (Criteria) this;
		}
     public Criteria andRealNameNotBetween(String value1, String value2) {
		   addCriterion("real_name not between", value1, value2, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameLike(String value) {
		  addCriterion("real_name like", value, "realName");
		return (Criteria) this;
		}
    public Criteria andRealNameNotLike(String value) {
		  addCriterion("real_name not like", value, "realName");
		return (Criteria) this;
		}
 public Criteria andJkTimeIsNull() {
		 addCriterion("jk_time is null");
		return (Criteria) this;
		}
  public Criteria andJkTimeIsNotNull(){
		addCriterion("jk_time is not null");
		return (Criteria) this;
		}
  public Criteria andJkTimeEqualTo(String value) {
		  addCriterion("jk_time =", value, "jkTime");
		return (Criteria) this;
		}
   public Criteria andJkTimeNotEqualTo(String value) {
		  addCriterion("jk_time <>", value, "jkTime");
		return (Criteria) this;
		}
    public Criteria andJkTimeGreaterThan(String value) {
		 addCriterion("jk_time >", value, "jkTime");
		return (Criteria) this;
		}
  public Criteria andJkTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("jk_time >=", value, "JkTime");
		return (Criteria) this;
		}
   public Criteria andJkTimeLessThan(String value) {
		  addCriterion("jk_time <", value, "jkTime");
		return (Criteria) this;
		}
    public Criteria andJkTimeLessThanOrEqualTo(String value) {
		  addCriterion("jk_time <=", value, "jkTime");
		return (Criteria) this;
		}
    public Criteria andJkTimeIn(List<String> values) {
		  addCriterion("jk_time in", values, "jkTime");
		return (Criteria) this;
		}
    public Criteria andJkTimeNotIn(List<String> values) {
		  addCriterion("jk_time not in", values, "jkTime");
		return (Criteria) this;
		}
     public Criteria andJkTimeBetween(String value1, String value2) {
		   addCriterion("jk_time between", value1, value2, "jkTime");
		return (Criteria) this;
		}
     public Criteria andJkTimeNotBetween(String value1, String value2) {
		   addCriterion("jk_time not between", value1, value2, "jkTime");
		return (Criteria) this;
		}
    public Criteria andJkTimeLike(String value) {
		  addCriterion("jk_time like", value, "jkTime");
		return (Criteria) this;
		}
    public Criteria andJkTimeNotLike(String value) {
		  addCriterion("jk_time not like", value, "jkTime");
		return (Criteria) this;
		}
 public Criteria andJkAmountIsNull() {
		 addCriterion("jk_amount is null");
		return (Criteria) this;
		}
  public Criteria andJkAmountIsNotNull(){
		addCriterion("jk_amount is not null");
		return (Criteria) this;
		}
  public Criteria andJkAmountEqualTo(Double value) {
		  addCriterion("jk_amount =", value, "jkAmount");
		return (Criteria) this;
		}
   public Criteria andJkAmountNotEqualTo(Double value) {
		  addCriterion("jk_amount <>", value, "jkAmount");
		return (Criteria) this;
		}
    public Criteria andJkAmountGreaterThan(Double value) {
		 addCriterion("jk_amount >", value, "jkAmount");
		return (Criteria) this;
		}
  public Criteria andJkAmountGreaterThanOrEqualTo(Double value) {
		  addCriterion("jk_amount >=", value, "JkAmount");
		return (Criteria) this;
		}
   public Criteria andJkAmountLessThan(Double value) {
		  addCriterion("jk_amount <", value, "jkAmount");
		return (Criteria) this;
		}
    public Criteria andJkAmountLessThanOrEqualTo(Double value) {
		  addCriterion("jk_amount <=", value, "jkAmount");
		return (Criteria) this;
		}
    public Criteria andJkAmountIn(List<Double> values) {
		  addCriterion("jk_amount in", values, "jkAmount");
		return (Criteria) this;
		}
    public Criteria andJkAmountNotIn(List<Double> values) {
		  addCriterion("jk_amount not in", values, "jkAmount");
		return (Criteria) this;
		}
     public Criteria andJkAmountBetween(Double value1, Double value2) {
		   addCriterion("jk_amount between", value1, value2, "jkAmount");
		return (Criteria) this;
		}
     public Criteria andJkAmountNotBetween(Double value1, Double value2) {
		   addCriterion("jk_amount not between", value1, value2, "jkAmount");
		return (Criteria) this;
		}
    public Criteria andJkAmountLike(Double value) {
		  addCriterion("jk_amount like", value, "jkAmount");
		return (Criteria) this;
		}
    public Criteria andJkAmountNotLike(Double value) {
		  addCriterion("jk_amount not like", value, "jkAmount");
		return (Criteria) this;
		}
 public Criteria andVolunteerIdIsNull() {
		 addCriterion("volunteer_id is null");
		return (Criteria) this;
		}
  public Criteria andVolunteerIdIsNotNull(){
		addCriterion("volunteer_id is not null");
		return (Criteria) this;
		}
  public Criteria andVolunteerIdEqualTo(Integer value) {
		  addCriterion("volunteer_id =", value, "volunteerId");
		return (Criteria) this;
		}
   public Criteria andVolunteerIdNotEqualTo(Integer value) {
		  addCriterion("volunteer_id <>", value, "volunteerId");
		return (Criteria) this;
		}
    public Criteria andVolunteerIdGreaterThan(Integer value) {
		 addCriterion("volunteer_id >", value, "volunteerId");
		return (Criteria) this;
		}
  public Criteria andVolunteerIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("volunteer_id >=", value, "VolunteerId");
		return (Criteria) this;
		}
   public Criteria andVolunteerIdLessThan(Integer value) {
		  addCriterion("volunteer_id <", value, "volunteerId");
		return (Criteria) this;
		}
    public Criteria andVolunteerIdLessThanOrEqualTo(Integer value) {
		  addCriterion("volunteer_id <=", value, "volunteerId");
		return (Criteria) this;
		}
    public Criteria andVolunteerIdIn(List<Integer> values) {
		  addCriterion("volunteer_id in", values, "volunteerId");
		return (Criteria) this;
		}
    public Criteria andVolunteerIdNotIn(List<Integer> values) {
		  addCriterion("volunteer_id not in", values, "volunteerId");
		return (Criteria) this;
		}
     public Criteria andVolunteerIdBetween(Integer value1, Integer value2) {
		   addCriterion("volunteer_id between", value1, value2, "volunteerId");
		return (Criteria) this;
		}
     public Criteria andVolunteerIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("volunteer_id not between", value1, value2, "volunteerId");
		return (Criteria) this;
		}
    public Criteria andVolunteerIdLike(Integer value) {
		  addCriterion("volunteer_id like", value, "volunteerId");
		return (Criteria) this;
		}
    public Criteria andVolunteerIdNotLike(Integer value) {
		  addCriterion("volunteer_id not like", value, "volunteerId");
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
