package com.fincare.accmangement.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AccountDao_Impl implements AccountDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Account> __insertionAdapterOfAccount;

  private final EntityDeletionOrUpdateAdapter<Account> __deletionAdapterOfAccount;

  private final EntityDeletionOrUpdateAdapter<Account> __updateAdapterOfAccount;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAlternateName;

  private final SharedSQLiteStatement __preparedStmtOfClearAccounts;

  public AccountDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAccount = new EntityInsertionAdapter<Account>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `accounts` (`id`,`ActName`,`actid`,`alternateName`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Account entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getActName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getActName());
        }
        if (entity.getActid() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getActid());
        }
        if (entity.getAlternateName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAlternateName());
        }
      }
    };
    this.__deletionAdapterOfAccount = new EntityDeletionOrUpdateAdapter<Account>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `accounts` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Account entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfAccount = new EntityDeletionOrUpdateAdapter<Account>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `accounts` SET `id` = ?,`ActName` = ?,`actid` = ?,`alternateName` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Account entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getActName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getActName());
        }
        if (entity.getActid() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getActid());
        }
        if (entity.getAlternateName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAlternateName());
        }
        statement.bindLong(5, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateAlternateName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE accounts SET alternateName = ? WHERE actid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearAccounts = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM accounts";
        return _query;
      }
    };
  }

  @Override
  public Object insertAccounts(final List<Account> accounts,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAccount.insert(accounts);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAccount(final Account account, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAccount.handle(account);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAccount(final Account account, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAccount.handle(account);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAlternateName(final String actId, final String alternateName,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAlternateName.acquire();
        int _argIndex = 1;
        if (alternateName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, alternateName);
        }
        _argIndex = 2;
        if (actId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, actId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateAlternateName.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAccounts(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAccounts.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearAccounts.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllAccounts(final Continuation<? super List<Account>> $completion) {
    final String _sql = "SELECT * FROM accounts";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Account>>() {
      @Override
      @NonNull
      public List<Account> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfActName = CursorUtil.getColumnIndexOrThrow(_cursor, "ActName");
          final int _cursorIndexOfActid = CursorUtil.getColumnIndexOrThrow(_cursor, "actid");
          final int _cursorIndexOfAlternateName = CursorUtil.getColumnIndexOrThrow(_cursor, "alternateName");
          final List<Account> _result = new ArrayList<Account>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Account _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpActName;
            if (_cursor.isNull(_cursorIndexOfActName)) {
              _tmpActName = null;
            } else {
              _tmpActName = _cursor.getString(_cursorIndexOfActName);
            }
            final String _tmpActid;
            if (_cursor.isNull(_cursorIndexOfActid)) {
              _tmpActid = null;
            } else {
              _tmpActid = _cursor.getString(_cursorIndexOfActid);
            }
            final String _tmpAlternateName;
            if (_cursor.isNull(_cursorIndexOfAlternateName)) {
              _tmpAlternateName = null;
            } else {
              _tmpAlternateName = _cursor.getString(_cursorIndexOfAlternateName);
            }
            _item = new Account(_tmpId,_tmpActName,_tmpActid,_tmpAlternateName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAccountById(final String accountId,
      final Continuation<? super Account> $completion) {
    final String _sql = "SELECT * FROM accounts WHERE actid = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (accountId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, accountId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Account>() {
      @Override
      @Nullable
      public Account call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfActName = CursorUtil.getColumnIndexOrThrow(_cursor, "ActName");
          final int _cursorIndexOfActid = CursorUtil.getColumnIndexOrThrow(_cursor, "actid");
          final int _cursorIndexOfAlternateName = CursorUtil.getColumnIndexOrThrow(_cursor, "alternateName");
          final Account _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpActName;
            if (_cursor.isNull(_cursorIndexOfActName)) {
              _tmpActName = null;
            } else {
              _tmpActName = _cursor.getString(_cursorIndexOfActName);
            }
            final String _tmpActid;
            if (_cursor.isNull(_cursorIndexOfActid)) {
              _tmpActid = null;
            } else {
              _tmpActid = _cursor.getString(_cursorIndexOfActid);
            }
            final String _tmpAlternateName;
            if (_cursor.isNull(_cursorIndexOfAlternateName)) {
              _tmpAlternateName = null;
            } else {
              _tmpAlternateName = _cursor.getString(_cursorIndexOfAlternateName);
            }
            _result = new Account(_tmpId,_tmpActName,_tmpActid,_tmpAlternateName);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
