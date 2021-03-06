package com.rapleaf.jack.store.executors;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.rapleaf.jack.IDb;
import com.rapleaf.jack.store.JsScope;
import com.rapleaf.jack.transaction.ITransactor;

public class JsExecutors<DB extends IDb> {

  private final ITransactor<DB> transactor;
  private final JsTable jsTable;
  private final Optional<JsScope> predefinedScope;
  private final List<String> predefinedScopeNames;

  public JsExecutors(ITransactor<DB> transactor, JsTable jsTable, JsScope executionScope) {
    this.transactor = transactor;
    this.jsTable = jsTable;
    this.predefinedScope = Optional.of(executionScope);
    this.predefinedScopeNames = Collections.emptyList();
  }

  public JsExecutors(ITransactor<DB> transactor, JsTable jsTable, List<String> executionScopeNames) {
    this.transactor = transactor;
    this.jsTable = jsTable;
    this.predefinedScope = Optional.empty();
    this.predefinedScopeNames = executionScopeNames;
  }

  public ScopeCreationExecutor<DB> createScope(String scopeName) {
    return new ScopeCreationExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames, scopeName);
  }

  public ScopeCreationExecutor<DB> createScope() {
    return new ScopeCreationExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames);
  }

  public ScopeModificationExecutor<DB> renameScope(String currentName, String newName) {
    return new ScopeModificationExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames, currentName, newName);
  }

  public ScopeGetterExecutor<DB> getScope(long scopeId) {
    return new ScopeGetterExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames, scopeId);
  }

  public ScopeGetterExecutor<DB> getScope(String scopeName) {
    return new ScopeGetterExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames, scopeName);
  }

  public ScopeQueryExecutor<DB> queryScope() {
    return new ScopeQueryExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames);
  }

  public ScopeDeletionExecutor<DB> deleteScope() {
    return new ScopeDeletionExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames);
  }

  public RecordIndexExecutor<DB> indexRecord() {
    return new RecordIndexExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames);
  }

  public RecordGetterExecutor<DB> getRecord() {
    return new RecordGetterExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames);
  }

  public RecordDeletionExecutor<DB> deleteRecord() {
    return new RecordDeletionExecutor<>(transactor, jsTable, predefinedScope, predefinedScopeNames);
  }

}
