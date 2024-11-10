package com.fight.model;
import java.util.ArrayList;
import java.util.List;
public class ActInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public ActInfoExample() {
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
 public Criteria andActTitleIsNull() {
		 addCriterion("act_title is null");
		return (Criteria) this;
		}
  public Criteria andActTitleIsNotNull(){
		addCriterion("act_title is not null");
		return (Criteria) this;
		}
  public Criteria andActTitleEqualTo(String value) {
		  addCriterion("act_title =", value, "actTitle");
		return (Criteria) this;
		}
   public Criteria andActTitleNotEqualTo(String value) {
		  addCriterion("act_title <>", value, "actTitle");
		return (Criteria) this;
		}
    public Criteria andActTitleGreaterThan(String value) {
		 addCriterion("act_title >", value, "actTitle");
		return (Criteria) this;
		}
  public Criteria andActTitleGreaterThanOrEqualTo(String value) {
		  addCriterion("act_title >=", value, "ActTitle");
		return (Criteria) this;
		}
   public Criteria andActTitleLessThan(String value) {
		  addCriterion("act_title <", value, "actTitle");
		return (Criteria) this;
		}
    public Criteria andActTitleLessThanOrEqualTo(String value) {
		  addCriterion("act_title <=", value, "actTitle");
		return (Criteria) this;
		}
    public Criteria andActTitleIn(List<String> values) {
		  addCriterion("act_title in", values, "actTitle");
		return (Criteria) this;
		}
    public Criteria andActTitleNotIn(List<String> values) {
		  addCriterion("act_title not in", values, "actTitle");
		return (Criteria) this;
		}
     public Criteria andActTitleBetween(String value1, String value2) {
		   addCriterion("act_title between", value1, value2, "actTitle");
		return (Criteria) this;
		}
     public Criteria andActTitleNotBetween(String value1, String value2) {
		   addCriterion("act_title not between", value1, value2, "actTitle");
		return (Criteria) this;
		}
    public Criteria andActTitleLike(String value) {
		  addCriterion("act_title like", value, "actTitle");
		return (Criteria) this;
		}
    public Criteria andActTitleNotLike(String value) {
		  addCriterion("act_title not like", value, "actTitle");
		return (Criteria) this;
		}
 public Criteria andActContentIsNull() {
		 addCriterion("act_content is null");
		return (Criteria) this;
		}
  public Criteria andActContentIsNotNull(){
		addCriterion("act_content is not null");
		return (Criteria) this;
		}
  public Criteria andActContentEqualTo(String value) {
		  addCriterion("act_content =", value, "actContent");
		return (Criteria) this;
		}
   public Criteria andActContentNotEqualTo(String value) {
		  addCriterion("act_content <>", value, "actContent");
		return (Criteria) this;
		}
    public Criteria andActContentGreaterThan(String value) {
		 addCriterion("act_content >", value, "actContent");
		return (Criteria) this;
		}
  public Criteria andActContentGreaterThanOrEqualTo(String value) {
		  addCriterion("act_content >=", value, "ActContent");
		return (Criteria) this;
		}
   public Criteria andActContentLessThan(String value) {
		  addCriterion("act_content <", value, "actContent");
		return (Criteria) this;
		}
    public Criteria andActContentLessThanOrEqualTo(String value) {
		  addCriterion("act_content <=", value, "actContent");
		return (Criteria) this;
		}
    public Criteria andActContentIn(List<String> values) {
		  addCriterion("act_content in", values, "actContent");
		return (Criteria) this;
		}
    public Criteria andActContentNotIn(List<String> values) {
		  addCriterion("act_content not in", values, "actContent");
		return (Criteria) this;
		}
     public Criteria andActContentBetween(String value1, String value2) {
		   addCriterion("act_content between", value1, value2, "actContent");
		return (Criteria) this;
		}
     public Criteria andActContentNotBetween(String value1, String value2) {
		   addCriterion("act_content not between", value1, value2, "actContent");
		return (Criteria) this;
		}
    public Criteria andActContentLike(String value) {
		  addCriterion("act_content like", value, "actContent");
		return (Criteria) this;
		}
    public Criteria andActContentNotLike(String value) {
		  addCriterion("act_content not like", value, "actContent");
		return (Criteria) this;
		}
 public Criteria andActImgIsNull() {
		 addCriterion("act_img is null");
		return (Criteria) this;
		}
  public Criteria andActImgIsNotNull(){
		addCriterion("act_img is not null");
		return (Criteria) this;
		}
  public Criteria andActImgEqualTo(String value) {
		  addCriterion("act_img =", value, "actImg");
		return (Criteria) this;
		}
   public Criteria andActImgNotEqualTo(String value) {
		  addCriterion("act_img <>", value, "actImg");
		return (Criteria) this;
		}
    public Criteria andActImgGreaterThan(String value) {
		 addCriterion("act_img >", value, "actImg");
		return (Criteria) this;
		}
  public Criteria andActImgGreaterThanOrEqualTo(String value) {
		  addCriterion("act_img >=", value, "ActImg");
		return (Criteria) this;
		}
   public Criteria andActImgLessThan(String value) {
		  addCriterion("act_img <", value, "actImg");
		return (Criteria) this;
		}
    public Criteria andActImgLessThanOrEqualTo(String value) {
		  addCriterion("act_img <=", value, "actImg");
		return (Criteria) this;
		}
    public Criteria andActImgIn(List<String> values) {
		  addCriterion("act_img in", values, "actImg");
		return (Criteria) this;
		}
    public Criteria andActImgNotIn(List<String> values) {
		  addCriterion("act_img not in", values, "actImg");
		return (Criteria) this;
		}
     public Criteria andActImgBetween(String value1, String value2) {
		   addCriterion("act_img between", value1, value2, "actImg");
		return (Criteria) this;
		}
     public Criteria andActImgNotBetween(String value1, String value2) {
		   addCriterion("act_img not between", value1, value2, "actImg");
		return (Criteria) this;
		}
    public Criteria andActImgLike(String value) {
		  addCriterion("act_img like", value, "actImg");
		return (Criteria) this;
		}
    public Criteria andActImgNotLike(String value) {
		  addCriterion("act_img not like", value, "actImg");
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
