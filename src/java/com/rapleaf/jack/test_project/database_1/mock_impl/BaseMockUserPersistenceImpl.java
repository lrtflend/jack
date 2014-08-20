
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.jack.test_project.database_1.mock_impl;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;

import com.rapleaf.jack.AbstractMockDatabaseModel;
import com.rapleaf.jack.ModelQuery;
import com.rapleaf.jack.ModelWithId;
import com.rapleaf.jack.QueryConstraint;
import com.rapleaf.jack.QueryOrder;
import com.rapleaf.jack.LimitCriterion;
import com.rapleaf.jack.OrderCriterion;

import com.rapleaf.jack.test_project.database_1.models.User;
import com.rapleaf.jack.test_project.database_1.models.User.Id;
import com.rapleaf.jack.test_project.database_1.iface.IUserPersistence;
import com.rapleaf.jack.test_project.database_1.query.UserQueryBuilder;

import com.rapleaf.jack.test_project.IDatabases;

public class BaseMockUserPersistenceImpl extends AbstractMockDatabaseModel<User, IDatabases> implements IUserPersistence {
  private final IDatabases databases;

  private static AtomicInteger curId = new AtomicInteger(1);

  public BaseMockUserPersistenceImpl(IDatabases databases) {
    super(databases);
    this.databases = databases;
  }

  @Override
  public User create(Map<Enum, Object> fieldsMap) throws IOException {
    String handle = (String) fieldsMap.get(User._Fields.handle);
    Long created_at_millis = (Long) fieldsMap.get(User._Fields.created_at_millis);
    int num_posts = (Integer) fieldsMap.get(User._Fields.num_posts);
    Long some_date = (Long) fieldsMap.get(User._Fields.some_date);
    Long some_datetime = (Long) fieldsMap.get(User._Fields.some_datetime);
    String bio = (String) fieldsMap.get(User._Fields.bio);
    byte[] some_binary = (byte[]) fieldsMap.get(User._Fields.some_binary);
    Double some_float = (Double) fieldsMap.get(User._Fields.some_float);
    Double some_decimal = (Double) fieldsMap.get(User._Fields.some_decimal);
    Boolean some_boolean = (Boolean) fieldsMap.get(User._Fields.some_boolean);
    return create(handle, created_at_millis, num_posts, some_date, some_datetime, bio, some_binary, some_float, some_decimal, some_boolean);
  }


  public User create(final String handle, final Long created_at_millis, final int num_posts, final Long some_date, final Long some_datetime, final String bio, final byte[] some_binary, final Double some_float, final Double some_decimal, final Boolean some_boolean) throws IOException {
    long __id = curId.getAndIncrement();
    User newInst = new User(__id, handle, created_at_millis, num_posts, some_date, some_datetime, bio, some_binary, some_float, some_decimal, some_boolean, databases);
    records.put(__id, newInst);
    clearForeignKeyCache();
    return newInst.getCopy();
  }



  public User create(final String handle, final int num_posts) throws IOException {
    long __id = curId.getAndIncrement();
    User newInst = new User(__id, handle, null, num_posts, null, null, null, null, null, null, null, databases);
    records.put(__id, newInst);
    clearForeignKeyCache();
    return newInst.getCopy();
  }


  public User createDefaultInstance() throws IOException {
    return create("", 0);
  }

  public Set<User> find(Map<Enum, Object> fieldsMap) throws IOException {
    return super.realFind(fieldsMap);
  }

  public Set<User> find(Set<Long> ids, Map<Enum, Object> fieldsMap) throws IOException {
    return super.realFind(ids, fieldsMap);
  }

  public Set<User> find(ModelQuery query) throws IOException {
    return super.realFind(query);
  }
  
  public List<User> findWithOrder(ModelQuery query) throws IOException {
    List<User> allResults = sortUnorderedMockQuery(super.realFind(query), query);
    LimitCriterion limitCriterion = query.getLimitCriterion();
    if(limitCriterion == null) {
      return allResults;
    }
    return allResults.subList(limitCriterion.getOffset(), limitCriterion.getNResults() + limitCriterion.getOffset());
  }

  private List<User> sortUnorderedMockQuery(Set<User> unorderedResult, ModelQuery query) {
    final List<OrderCriterion> orderCriteria = query.getOrderCriteria();
    List<User> result = new ArrayList<User>(unorderedResult);

    Collections.sort(result, new Comparator<User>() {
      public int compare(User t1, User t2) {
        for (OrderCriterion orderCriterion : orderCriteria) {
          int compareResult;
          Enum field = orderCriterion.getField();
          String fieldName = field != null ? field.toString() : "id";

          Object o1 = field != null ? t1.getField(fieldName) : t1.getId();
          Object o2 = field != null ? t2.getField(fieldName) : t2.getId();
          if (o1 instanceof java.lang.Comparable) {
            compareResult = ((Comparable) o1).compareTo((Comparable) o2);
          } else {
            compareResult = Integer.valueOf(o1.hashCode()).compareTo(o2.hashCode());
          }

          int orderDirection = (orderCriterion.getOrder() == QueryOrder.ASC) ? 1 : -1;
          compareResult = compareResult * orderDirection;
          if (compareResult != 0) {
            if (compareResult < 0) {
              return -1;
            } else {
              return 1;
            }
          }
        }
        return 0;
      }
    });

    return result;    
  }

  public Set<User> findByHandle(final String value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.handle, value);}});
  }

  public Set<User> findByCreatedAtMillis(final Long value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.created_at_millis, value);}});
  }

  public Set<User> findByNumPosts(final int value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.num_posts, value);}});
  }

  public Set<User> findBySomeDate(final Long value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.some_date, value);}});
  }

  public Set<User> findBySomeDatetime(final Long value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.some_datetime, value);}});
  }

  public Set<User> findByBio(final String value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.bio, value);}});
  }

  public Set<User> findBySomeBinary(final byte[] value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.some_binary, value);}});
  }

  public Set<User> findBySomeFloat(final Double value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.some_float, value);}});
  }

  public Set<User> findBySomeDecimal(final Double value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.some_decimal, value);}});
  }

  public Set<User> findBySomeBoolean(final Boolean value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(User._Fields.some_boolean, value);}});
  }

  public UserQueryBuilder query() {
    return new UserQueryBuilder(this);
  }
}
