package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkPerformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkPerformExample() {
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

        public Criteria andPerformIdIsNull() {
            addCriterion("perform_id is null");
            return (Criteria) this;
        }

        public Criteria andPerformIdIsNotNull() {
            addCriterion("perform_id is not null");
            return (Criteria) this;
        }

        public Criteria andPerformIdEqualTo(String value) {
            addCriterion("perform_id =", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdNotEqualTo(String value) {
            addCriterion("perform_id <>", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdGreaterThan(String value) {
            addCriterion("perform_id >", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdGreaterThanOrEqualTo(String value) {
            addCriterion("perform_id >=", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdLessThan(String value) {
            addCriterion("perform_id <", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdLessThanOrEqualTo(String value) {
            addCriterion("perform_id <=", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdLike(String value) {
            addCriterion("perform_id like", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdNotLike(String value) {
            addCriterion("perform_id not like", value, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdIn(List<String> values) {
            addCriterion("perform_id in", values, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdNotIn(List<String> values) {
            addCriterion("perform_id not in", values, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdBetween(String value1, String value2) {
            addCriterion("perform_id between", value1, value2, "performId");
            return (Criteria) this;
        }

        public Criteria andPerformIdNotBetween(String value1, String value2) {
            addCriterion("perform_id not between", value1, value2, "performId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdIsNull() {
            addCriterion("work_task_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdIsNotNull() {
            addCriterion("work_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdEqualTo(String value) {
            addCriterion("work_task_id =", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdNotEqualTo(String value) {
            addCriterion("work_task_id <>", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdGreaterThan(String value) {
            addCriterion("work_task_id >", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_task_id >=", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdLessThan(String value) {
            addCriterion("work_task_id <", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdLessThanOrEqualTo(String value) {
            addCriterion("work_task_id <=", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdLike(String value) {
            addCriterion("work_task_id like", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdNotLike(String value) {
            addCriterion("work_task_id not like", value, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdIn(List<String> values) {
            addCriterion("work_task_id in", values, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdNotIn(List<String> values) {
            addCriterion("work_task_id not in", values, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdBetween(String value1, String value2) {
            addCriterion("work_task_id between", value1, value2, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIdNotBetween(String value1, String value2) {
            addCriterion("work_task_id not between", value1, value2, "workTaskId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNull() {
            addCriterion("complete_time is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(Date value) {
            addCriterion("complete_time =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(Date value) {
            addCriterion("complete_time <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(Date value) {
            addCriterion("complete_time >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complete_time >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(Date value) {
            addCriterion("complete_time <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("complete_time <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<Date> values) {
            addCriterion("complete_time in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<Date> values) {
            addCriterion("complete_time not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("complete_time between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("complete_time not between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andDealPeopleIsNull() {
            addCriterion("deal_people is null");
            return (Criteria) this;
        }

        public Criteria andDealPeopleIsNotNull() {
            addCriterion("deal_people is not null");
            return (Criteria) this;
        }

        public Criteria andDealPeopleEqualTo(String value) {
            addCriterion("deal_people =", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleNotEqualTo(String value) {
            addCriterion("deal_people <>", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleGreaterThan(String value) {
            addCriterion("deal_people >", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("deal_people >=", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleLessThan(String value) {
            addCriterion("deal_people <", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleLessThanOrEqualTo(String value) {
            addCriterion("deal_people <=", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleLike(String value) {
            addCriterion("deal_people like", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleNotLike(String value) {
            addCriterion("deal_people not like", value, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleIn(List<String> values) {
            addCriterion("deal_people in", values, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleNotIn(List<String> values) {
            addCriterion("deal_people not in", values, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleBetween(String value1, String value2) {
            addCriterion("deal_people between", value1, value2, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andDealPeopleNotBetween(String value1, String value2) {
            addCriterion("deal_people not between", value1, value2, "dealPeople");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNull() {
            addCriterion("participants is null");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNotNull() {
            addCriterion("participants is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantsEqualTo(String value) {
            addCriterion("participants =", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotEqualTo(String value) {
            addCriterion("participants <>", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThan(String value) {
            addCriterion("participants >", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThanOrEqualTo(String value) {
            addCriterion("participants >=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThan(String value) {
            addCriterion("participants <", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThanOrEqualTo(String value) {
            addCriterion("participants <=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLike(String value) {
            addCriterion("participants like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotLike(String value) {
            addCriterion("participants not like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsIn(List<String> values) {
            addCriterion("participants in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotIn(List<String> values) {
            addCriterion("participants not in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsBetween(String value1, String value2) {
            addCriterion("participants between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotBetween(String value1, String value2) {
            addCriterion("participants not between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andCompletionIsNull() {
            addCriterion("completion is null");
            return (Criteria) this;
        }

        public Criteria andCompletionIsNotNull() {
            addCriterion("completion is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionEqualTo(String value) {
            addCriterion("completion =", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotEqualTo(String value) {
            addCriterion("completion <>", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionGreaterThan(String value) {
            addCriterion("completion >", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionGreaterThanOrEqualTo(String value) {
            addCriterion("completion >=", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLessThan(String value) {
            addCriterion("completion <", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLessThanOrEqualTo(String value) {
            addCriterion("completion <=", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLike(String value) {
            addCriterion("completion like", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotLike(String value) {
            addCriterion("completion not like", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionIn(List<String> values) {
            addCriterion("completion in", values, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotIn(List<String> values) {
            addCriterion("completion not in", values, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionBetween(String value1, String value2) {
            addCriterion("completion between", value1, value2, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotBetween(String value1, String value2) {
            addCriterion("completion not between", value1, value2, "completion");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("question is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("question is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("question <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("question like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("question not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeIsNull() {
            addCriterion("launch_time is null");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeIsNotNull() {
            addCriterion("launch_time is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeEqualTo(Date value) {
            addCriterion("launch_time =", value, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeNotEqualTo(Date value) {
            addCriterion("launch_time <>", value, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeGreaterThan(Date value) {
            addCriterion("launch_time >", value, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("launch_time >=", value, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeLessThan(Date value) {
            addCriterion("launch_time <", value, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeLessThanOrEqualTo(Date value) {
            addCriterion("launch_time <=", value, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeIn(List<Date> values) {
            addCriterion("launch_time in", values, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeNotIn(List<Date> values) {
            addCriterion("launch_time not in", values, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeBetween(Date value1, Date value2) {
            addCriterion("launch_time between", value1, value2, "launchTime");
            return (Criteria) this;
        }

        public Criteria andLaunchTimeNotBetween(Date value1, Date value2) {
            addCriterion("launch_time not between", value1, value2, "launchTime");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIsNull() {
            addCriterion("complete_status is null");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIsNotNull() {
            addCriterion("complete_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusEqualTo(String value) {
            addCriterion("complete_status =", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotEqualTo(String value) {
            addCriterion("complete_status <>", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusGreaterThan(String value) {
            addCriterion("complete_status >", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusGreaterThanOrEqualTo(String value) {
            addCriterion("complete_status >=", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLessThan(String value) {
            addCriterion("complete_status <", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLessThanOrEqualTo(String value) {
            addCriterion("complete_status <=", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLike(String value) {
            addCriterion("complete_status like", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotLike(String value) {
            addCriterion("complete_status not like", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIn(List<String> values) {
            addCriterion("complete_status in", values, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotIn(List<String> values) {
            addCriterion("complete_status not in", values, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusBetween(String value1, String value2) {
            addCriterion("complete_status between", value1, value2, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotBetween(String value1, String value2) {
            addCriterion("complete_status not between", value1, value2, "completeStatus");
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