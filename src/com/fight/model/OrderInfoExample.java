package com.fight.model;
import java.util.ArrayList;
import java.util.List;
public class OrderInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public OrderInfoExample() {
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
 public Criteria andNeedIdIsNull() {
		 addCriterion("need_id is null");
		return (Criteria) this;
		}
  public Criteria andNeedIdIsNotNull(){
		addCriterion("need_id is not null");
		return (Criteria) this;
		}
  public Criteria andNeedIdEqualTo(Integer value) {
		  addCriterion("need_id =", value, "needId");
		return (Criteria) this;
		}
   public Criteria andNeedIdNotEqualTo(Integer value) {
		  addCriterion("need_id <>", value, "needId");
		return (Criteria) this;
		}
    public Criteria andNeedIdGreaterThan(Integer value) {
		 addCriterion("need_id >", value, "needId");
		return (Criteria) this;
		}
  public Criteria andNeedIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("need_id >=", value, "NeedId");
		return (Criteria) this;
		}
   public Criteria andNeedIdLessThan(Integer value) {
		  addCriterion("need_id <", value, "needId");
		return (Criteria) this;
		}
    public Criteria andNeedIdLessThanOrEqualTo(Integer value) {
		  addCriterion("need_id <=", value, "needId");
		return (Criteria) this;
		}
    public Criteria andNeedIdIn(List<Integer> values) {
		  addCriterion("need_id in", values, "needId");
		return (Criteria) this;
		}
    public Criteria andNeedIdNotIn(List<Integer> values) {
		  addCriterion("need_id not in", values, "needId");
		return (Criteria) this;
		}
     public Criteria andNeedIdBetween(Integer value1, Integer value2) {
		   addCriterion("need_id between", value1, value2, "needId");
		return (Criteria) this;
		}
     public Criteria andNeedIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("need_id not between", value1, value2, "needId");
		return (Criteria) this;
		}
    public Criteria andNeedIdLike(Integer value) {
		  addCriterion("need_id like", value, "needId");
		return (Criteria) this;
		}
    public Criteria andNeedIdNotLike(Integer value) {
		  addCriterion("need_id not like", value, "needId");
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
 public Criteria andNumIsNull() {
		 addCriterion("num is null");
		return (Criteria) this;
		}
  public Criteria andNumIsNotNull(){
		addCriterion("num is not null");
		return (Criteria) this;
		}
  public Criteria andNumEqualTo(Integer value) {
		  addCriterion("num =", value, "num");
		return (Criteria) this;
		}
   public Criteria andNumNotEqualTo(Integer value) {
		  addCriterion("num <>", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumGreaterThan(Integer value) {
		 addCriterion("num >", value, "num");
		return (Criteria) this;
		}
  public Criteria andNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("num >=", value, "Num");
		return (Criteria) this;
		}
   public Criteria andNumLessThan(Integer value) {
		  addCriterion("num <", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumLessThanOrEqualTo(Integer value) {
		  addCriterion("num <=", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumIn(List<Integer> values) {
		  addCriterion("num in", values, "num");
		return (Criteria) this;
		}
    public Criteria andNumNotIn(List<Integer> values) {
		  addCriterion("num not in", values, "num");
		return (Criteria) this;
		}
     public Criteria andNumBetween(Integer value1, Integer value2) {
		   addCriterion("num between", value1, value2, "num");
		return (Criteria) this;
		}
     public Criteria andNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("num not between", value1, value2, "num");
		return (Criteria) this;
		}
    public Criteria andNumLike(Integer value) {
		  addCriterion("num like", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumNotLike(Integer value) {
		  addCriterion("num not like", value, "num");
		return (Criteria) this;
		}
 public Criteria andPriceIsNull() {
		 addCriterion("price is null");
		return (Criteria) this;
		}
  public Criteria andPriceIsNotNull(){
		addCriterion("price is not null");
		return (Criteria) this;
		}
  public Criteria andPriceEqualTo(Double value) {
		  addCriterion("price =", value, "price");
		return (Criteria) this;
		}
   public Criteria andPriceNotEqualTo(Double value) {
		  addCriterion("price <>", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceGreaterThan(Double value) {
		 addCriterion("price >", value, "price");
		return (Criteria) this;
		}
  public Criteria andPriceGreaterThanOrEqualTo(Double value) {
		  addCriterion("price >=", value, "Price");
		return (Criteria) this;
		}
   public Criteria andPriceLessThan(Double value) {
		  addCriterion("price <", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceLessThanOrEqualTo(Double value) {
		  addCriterion("price <=", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceIn(List<Double> values) {
		  addCriterion("price in", values, "price");
		return (Criteria) this;
		}
    public Criteria andPriceNotIn(List<Double> values) {
		  addCriterion("price not in", values, "price");
		return (Criteria) this;
		}
     public Criteria andPriceBetween(Double value1, Double value2) {
		   addCriterion("price between", value1, value2, "price");
		return (Criteria) this;
		}
     public Criteria andPriceNotBetween(Double value1, Double value2) {
		   addCriterion("price not between", value1, value2, "price");
		return (Criteria) this;
		}
    public Criteria andPriceLike(Double value) {
		  addCriterion("price like", value, "price");
		return (Criteria) this;
		}
    public Criteria andPriceNotLike(Double value) {
		  addCriterion("price not like", value, "price");
		return (Criteria) this;
		}
 public Criteria andOutTimeIsNull() {
		 addCriterion("out_time is null");
		return (Criteria) this;
		}
  public Criteria andOutTimeIsNotNull(){
		addCriterion("out_time is not null");
		return (Criteria) this;
		}
  public Criteria andOutTimeEqualTo(String value) {
		  addCriterion("out_time =", value, "outTime");
		return (Criteria) this;
		}
   public Criteria andOutTimeNotEqualTo(String value) {
		  addCriterion("out_time <>", value, "outTime");
		return (Criteria) this;
		}
    public Criteria andOutTimeGreaterThan(String value) {
		 addCriterion("out_time >", value, "outTime");
		return (Criteria) this;
		}
  public Criteria andOutTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("out_time >=", value, "OutTime");
		return (Criteria) this;
		}
   public Criteria andOutTimeLessThan(String value) {
		  addCriterion("out_time <", value, "outTime");
		return (Criteria) this;
		}
    public Criteria andOutTimeLessThanOrEqualTo(String value) {
		  addCriterion("out_time <=", value, "outTime");
		return (Criteria) this;
		}
    public Criteria andOutTimeIn(List<String> values) {
		  addCriterion("out_time in", values, "outTime");
		return (Criteria) this;
		}
    public Criteria andOutTimeNotIn(List<String> values) {
		  addCriterion("out_time not in", values, "outTime");
		return (Criteria) this;
		}
     public Criteria andOutTimeBetween(String value1, String value2) {
		   addCriterion("out_time between", value1, value2, "outTime");
		return (Criteria) this;
		}
     public Criteria andOutTimeNotBetween(String value1, String value2) {
		   addCriterion("out_time not between", value1, value2, "outTime");
		return (Criteria) this;
		}
    public Criteria andOutTimeLike(String value) {
		  addCriterion("out_time like", value, "outTime");
		return (Criteria) this;
		}
    public Criteria andOutTimeNotLike(String value) {
		  addCriterion("out_time not like", value, "outTime");
		return (Criteria) this;
		}
 public Criteria andCompanyIdIsNull() {
		 addCriterion("company_id is null");
		return (Criteria) this;
		}
  public Criteria andCompanyIdIsNotNull(){
		addCriterion("company_id is not null");
		return (Criteria) this;
		}
  public Criteria andCompanyIdEqualTo(Integer value) {
		  addCriterion("company_id =", value, "companyId");
		return (Criteria) this;
		}
   public Criteria andCompanyIdNotEqualTo(Integer value) {
		  addCriterion("company_id <>", value, "companyId");
		return (Criteria) this;
		}
    public Criteria andCompanyIdGreaterThan(Integer value) {
		 addCriterion("company_id >", value, "companyId");
		return (Criteria) this;
		}
  public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("company_id >=", value, "CompanyId");
		return (Criteria) this;
		}
   public Criteria andCompanyIdLessThan(Integer value) {
		  addCriterion("company_id <", value, "companyId");
		return (Criteria) this;
		}
    public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
		  addCriterion("company_id <=", value, "companyId");
		return (Criteria) this;
		}
    public Criteria andCompanyIdIn(List<Integer> values) {
		  addCriterion("company_id in", values, "companyId");
		return (Criteria) this;
		}
    public Criteria andCompanyIdNotIn(List<Integer> values) {
		  addCriterion("company_id not in", values, "companyId");
		return (Criteria) this;
		}
     public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
		   addCriterion("company_id between", value1, value2, "companyId");
		return (Criteria) this;
		}
     public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("company_id not between", value1, value2, "companyId");
		return (Criteria) this;
		}
    public Criteria andCompanyIdLike(Integer value) {
		  addCriterion("company_id like", value, "companyId");
		return (Criteria) this;
		}
    public Criteria andCompanyIdNotLike(Integer value) {
		  addCriterion("company_id not like", value, "companyId");
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
 public Criteria andHospitalAddressIsNull() {
		 addCriterion("hospital_address is null");
		return (Criteria) this;
		}
  public Criteria andHospitalAddressIsNotNull(){
		addCriterion("hospital_address is not null");
		return (Criteria) this;
		}
  public Criteria andHospitalAddressEqualTo(String value) {
		  addCriterion("hospital_address =", value, "hospitalAddress");
		return (Criteria) this;
		}
   public Criteria andHospitalAddressNotEqualTo(String value) {
		  addCriterion("hospital_address <>", value, "hospitalAddress");
		return (Criteria) this;
		}
    public Criteria andHospitalAddressGreaterThan(String value) {
		 addCriterion("hospital_address >", value, "hospitalAddress");
		return (Criteria) this;
		}
  public Criteria andHospitalAddressGreaterThanOrEqualTo(String value) {
		  addCriterion("hospital_address >=", value, "HospitalAddress");
		return (Criteria) this;
		}
   public Criteria andHospitalAddressLessThan(String value) {
		  addCriterion("hospital_address <", value, "hospitalAddress");
		return (Criteria) this;
		}
    public Criteria andHospitalAddressLessThanOrEqualTo(String value) {
		  addCriterion("hospital_address <=", value, "hospitalAddress");
		return (Criteria) this;
		}
    public Criteria andHospitalAddressIn(List<String> values) {
		  addCriterion("hospital_address in", values, "hospitalAddress");
		return (Criteria) this;
		}
    public Criteria andHospitalAddressNotIn(List<String> values) {
		  addCriterion("hospital_address not in", values, "hospitalAddress");
		return (Criteria) this;
		}
     public Criteria andHospitalAddressBetween(String value1, String value2) {
		   addCriterion("hospital_address between", value1, value2, "hospitalAddress");
		return (Criteria) this;
		}
     public Criteria andHospitalAddressNotBetween(String value1, String value2) {
		   addCriterion("hospital_address not between", value1, value2, "hospitalAddress");
		return (Criteria) this;
		}
    public Criteria andHospitalAddressLike(String value) {
		  addCriterion("hospital_address like", value, "hospitalAddress");
		return (Criteria) this;
		}
    public Criteria andHospitalAddressNotLike(String value) {
		  addCriterion("hospital_address not like", value, "hospitalAddress");
		return (Criteria) this;
		}
 public Criteria andOrderStatusIsNull() {
		 addCriterion("order_status is null");
		return (Criteria) this;
		}
  public Criteria andOrderStatusIsNotNull(){
		addCriterion("order_status is not null");
		return (Criteria) this;
		}
  public Criteria andOrderStatusEqualTo(Integer value) {
		  addCriterion("order_status =", value, "orderStatus");
		return (Criteria) this;
		}
   public Criteria andOrderStatusNotEqualTo(Integer value) {
		  addCriterion("order_status <>", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusGreaterThan(Integer value) {
		 addCriterion("order_status >", value, "orderStatus");
		return (Criteria) this;
		}
  public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("order_status >=", value, "OrderStatus");
		return (Criteria) this;
		}
   public Criteria andOrderStatusLessThan(Integer value) {
		  addCriterion("order_status <", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("order_status <=", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusIn(List<Integer> values) {
		  addCriterion("order_status in", values, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusNotIn(List<Integer> values) {
		  addCriterion("order_status not in", values, "orderStatus");
		return (Criteria) this;
		}
     public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
		   addCriterion("order_status between", value1, value2, "orderStatus");
		return (Criteria) this;
		}
     public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("order_status not between", value1, value2, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusLike(Integer value) {
		  addCriterion("order_status like", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusNotLike(Integer value) {
		  addCriterion("order_status not like", value, "orderStatus");
		return (Criteria) this;
		}
 public Criteria andTotalAmountIsNull() {
		 addCriterion("total_amount is null");
		return (Criteria) this;
		}
  public Criteria andTotalAmountIsNotNull(){
		addCriterion("total_amount is not null");
		return (Criteria) this;
		}
  public Criteria andTotalAmountEqualTo(Double value) {
		  addCriterion("total_amount =", value, "totalAmount");
		return (Criteria) this;
		}
   public Criteria andTotalAmountNotEqualTo(Double value) {
		  addCriterion("total_amount <>", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountGreaterThan(Double value) {
		 addCriterion("total_amount >", value, "totalAmount");
		return (Criteria) this;
		}
  public Criteria andTotalAmountGreaterThanOrEqualTo(Double value) {
		  addCriterion("total_amount >=", value, "TotalAmount");
		return (Criteria) this;
		}
   public Criteria andTotalAmountLessThan(Double value) {
		  addCriterion("total_amount <", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountLessThanOrEqualTo(Double value) {
		  addCriterion("total_amount <=", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountIn(List<Double> values) {
		  addCriterion("total_amount in", values, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountNotIn(List<Double> values) {
		  addCriterion("total_amount not in", values, "totalAmount");
		return (Criteria) this;
		}
     public Criteria andTotalAmountBetween(Double value1, Double value2) {
		   addCriterion("total_amount between", value1, value2, "totalAmount");
		return (Criteria) this;
		}
     public Criteria andTotalAmountNotBetween(Double value1, Double value2) {
		   addCriterion("total_amount not between", value1, value2, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountLike(Double value) {
		  addCriterion("total_amount like", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountNotLike(Double value) {
		  addCriterion("total_amount not like", value, "totalAmount");
		return (Criteria) this;
		}
 public Criteria andQrTimeIsNull() {
		 addCriterion("qr_time is null");
		return (Criteria) this;
		}
  public Criteria andQrTimeIsNotNull(){
		addCriterion("qr_time is not null");
		return (Criteria) this;
		}
  public Criteria andQrTimeEqualTo(String value) {
		  addCriterion("qr_time =", value, "qrTime");
		return (Criteria) this;
		}
   public Criteria andQrTimeNotEqualTo(String value) {
		  addCriterion("qr_time <>", value, "qrTime");
		return (Criteria) this;
		}
    public Criteria andQrTimeGreaterThan(String value) {
		 addCriterion("qr_time >", value, "qrTime");
		return (Criteria) this;
		}
  public Criteria andQrTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("qr_time >=", value, "QrTime");
		return (Criteria) this;
		}
   public Criteria andQrTimeLessThan(String value) {
		  addCriterion("qr_time <", value, "qrTime");
		return (Criteria) this;
		}
    public Criteria andQrTimeLessThanOrEqualTo(String value) {
		  addCriterion("qr_time <=", value, "qrTime");
		return (Criteria) this;
		}
    public Criteria andQrTimeIn(List<String> values) {
		  addCriterion("qr_time in", values, "qrTime");
		return (Criteria) this;
		}
    public Criteria andQrTimeNotIn(List<String> values) {
		  addCriterion("qr_time not in", values, "qrTime");
		return (Criteria) this;
		}
     public Criteria andQrTimeBetween(String value1, String value2) {
		   addCriterion("qr_time between", value1, value2, "qrTime");
		return (Criteria) this;
		}
     public Criteria andQrTimeNotBetween(String value1, String value2) {
		   addCriterion("qr_time not between", value1, value2, "qrTime");
		return (Criteria) this;
		}
    public Criteria andQrTimeLike(String value) {
		  addCriterion("qr_time like", value, "qrTime");
		return (Criteria) this;
		}
    public Criteria andQrTimeNotLike(String value) {
		  addCriterion("qr_time not like", value, "qrTime");
		return (Criteria) this;
		}
 public Criteria andCarIdIsNull() {
		 addCriterion("car_id is null");
		return (Criteria) this;
		}
  public Criteria andCarIdIsNotNull(){
		addCriterion("car_id is not null");
		return (Criteria) this;
		}
  public Criteria andCarIdEqualTo(Integer value) {
		  addCriterion("car_id =", value, "carId");
		return (Criteria) this;
		}
   public Criteria andCarIdNotEqualTo(Integer value) {
		  addCriterion("car_id <>", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdGreaterThan(Integer value) {
		 addCriterion("car_id >", value, "carId");
		return (Criteria) this;
		}
  public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("car_id >=", value, "CarId");
		return (Criteria) this;
		}
   public Criteria andCarIdLessThan(Integer value) {
		  addCriterion("car_id <", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdLessThanOrEqualTo(Integer value) {
		  addCriterion("car_id <=", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdIn(List<Integer> values) {
		  addCriterion("car_id in", values, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdNotIn(List<Integer> values) {
		  addCriterion("car_id not in", values, "carId");
		return (Criteria) this;
		}
     public Criteria andCarIdBetween(Integer value1, Integer value2) {
		   addCriterion("car_id between", value1, value2, "carId");
		return (Criteria) this;
		}
     public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("car_id not between", value1, value2, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdLike(Integer value) {
		  addCriterion("car_id like", value, "carId");
		return (Criteria) this;
		}
    public Criteria andCarIdNotLike(Integer value) {
		  addCriterion("car_id not like", value, "carId");
		return (Criteria) this;
		}
 public Criteria andCarTypeIsNull() {
		 addCriterion("car_type is null");
		return (Criteria) this;
		}
  public Criteria andCarTypeIsNotNull(){
		addCriterion("car_type is not null");
		return (Criteria) this;
		}
  public Criteria andCarTypeEqualTo(String value) {
		  addCriterion("car_type =", value, "carType");
		return (Criteria) this;
		}
   public Criteria andCarTypeNotEqualTo(String value) {
		  addCriterion("car_type <>", value, "carType");
		return (Criteria) this;
		}
    public Criteria andCarTypeGreaterThan(String value) {
		 addCriterion("car_type >", value, "carType");
		return (Criteria) this;
		}
  public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
		  addCriterion("car_type >=", value, "CarType");
		return (Criteria) this;
		}
   public Criteria andCarTypeLessThan(String value) {
		  addCriterion("car_type <", value, "carType");
		return (Criteria) this;
		}
    public Criteria andCarTypeLessThanOrEqualTo(String value) {
		  addCriterion("car_type <=", value, "carType");
		return (Criteria) this;
		}
    public Criteria andCarTypeIn(List<String> values) {
		  addCriterion("car_type in", values, "carType");
		return (Criteria) this;
		}
    public Criteria andCarTypeNotIn(List<String> values) {
		  addCriterion("car_type not in", values, "carType");
		return (Criteria) this;
		}
     public Criteria andCarTypeBetween(String value1, String value2) {
		   addCriterion("car_type between", value1, value2, "carType");
		return (Criteria) this;
		}
     public Criteria andCarTypeNotBetween(String value1, String value2) {
		   addCriterion("car_type not between", value1, value2, "carType");
		return (Criteria) this;
		}
    public Criteria andCarTypeLike(String value) {
		  addCriterion("car_type like", value, "carType");
		return (Criteria) this;
		}
    public Criteria andCarTypeNotLike(String value) {
		  addCriterion("car_type not like", value, "carType");
		return (Criteria) this;
		}
 public Criteria andContactNameIsNull() {
		 addCriterion("contact_name is null");
		return (Criteria) this;
		}
  public Criteria andContactNameIsNotNull(){
		addCriterion("contact_name is not null");
		return (Criteria) this;
		}
  public Criteria andContactNameEqualTo(String value) {
		  addCriterion("contact_name =", value, "contactName");
		return (Criteria) this;
		}
   public Criteria andContactNameNotEqualTo(String value) {
		  addCriterion("contact_name <>", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameGreaterThan(String value) {
		 addCriterion("contact_name >", value, "contactName");
		return (Criteria) this;
		}
  public Criteria andContactNameGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_name >=", value, "ContactName");
		return (Criteria) this;
		}
   public Criteria andContactNameLessThan(String value) {
		  addCriterion("contact_name <", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameLessThanOrEqualTo(String value) {
		  addCriterion("contact_name <=", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameIn(List<String> values) {
		  addCriterion("contact_name in", values, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameNotIn(List<String> values) {
		  addCriterion("contact_name not in", values, "contactName");
		return (Criteria) this;
		}
     public Criteria andContactNameBetween(String value1, String value2) {
		   addCriterion("contact_name between", value1, value2, "contactName");
		return (Criteria) this;
		}
     public Criteria andContactNameNotBetween(String value1, String value2) {
		   addCriterion("contact_name not between", value1, value2, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameLike(String value) {
		  addCriterion("contact_name like", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameNotLike(String value) {
		  addCriterion("contact_name not like", value, "contactName");
		return (Criteria) this;
		}
 public Criteria andContactCelIsNull() {
		 addCriterion("contact_cel is null");
		return (Criteria) this;
		}
  public Criteria andContactCelIsNotNull(){
		addCriterion("contact_cel is not null");
		return (Criteria) this;
		}
  public Criteria andContactCelEqualTo(String value) {
		  addCriterion("contact_cel =", value, "contactCel");
		return (Criteria) this;
		}
   public Criteria andContactCelNotEqualTo(String value) {
		  addCriterion("contact_cel <>", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelGreaterThan(String value) {
		 addCriterion("contact_cel >", value, "contactCel");
		return (Criteria) this;
		}
  public Criteria andContactCelGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_cel >=", value, "ContactCel");
		return (Criteria) this;
		}
   public Criteria andContactCelLessThan(String value) {
		  addCriterion("contact_cel <", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelLessThanOrEqualTo(String value) {
		  addCriterion("contact_cel <=", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelIn(List<String> values) {
		  addCriterion("contact_cel in", values, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelNotIn(List<String> values) {
		  addCriterion("contact_cel not in", values, "contactCel");
		return (Criteria) this;
		}
     public Criteria andContactCelBetween(String value1, String value2) {
		   addCriterion("contact_cel between", value1, value2, "contactCel");
		return (Criteria) this;
		}
     public Criteria andContactCelNotBetween(String value1, String value2) {
		   addCriterion("contact_cel not between", value1, value2, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelLike(String value) {
		  addCriterion("contact_cel like", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelNotLike(String value) {
		  addCriterion("contact_cel not like", value, "contactCel");
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
