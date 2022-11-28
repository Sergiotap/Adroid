package com.example.bases_app;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class userDAO_Impl implements userDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<user> __insertionAdapterOfuser;

  private final EntityDeletionOrUpdateAdapter<user> __deletionAdapterOfuser;

  public userDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfuser = new EntityInsertionAdapter<user>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `usuarios` (`uid`,`nombre`,`telefono`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, user value) {
        if (value.uid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uid);
        }
        if (value.nombre == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.nombre);
        }
        if (value.telefono == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.telefono);
        }
      }
    };
    this.__deletionAdapterOfuser = new EntityDeletionOrUpdateAdapter<user>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `usuarios` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, user value) {
        if (value.uid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uid);
        }
      }
    };
  }

  @Override
  public void insertAll(final user... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfuser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final user user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfuser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<user> getAll() {
    final String _sql = "SELECT * FROM usuarios";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final List<user> _result = new ArrayList<user>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final user _item;
        _item = new user();
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _item.uid = null;
        } else {
          _item.uid = _cursor.getString(_cursorIndexOfUid);
        }
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _item.nombre = null;
        } else {
          _item.nombre = _cursor.getString(_cursorIndexOfNombre);
        }
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _item.telefono = null;
        } else {
          _item.telefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<user> loadAllByIds(final int[] userIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM usuarios WHERE uid IN (");
    final int _inputSize = userIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : userIds) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final List<user> _result = new ArrayList<user>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final user _item_1;
        _item_1 = new user();
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _item_1.uid = null;
        } else {
          _item_1.uid = _cursor.getString(_cursorIndexOfUid);
        }
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _item_1.nombre = null;
        } else {
          _item_1.nombre = _cursor.getString(_cursorIndexOfNombre);
        }
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _item_1.telefono = null;
        } else {
          _item_1.telefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public user findByName(final String nombre) {
    final String _sql = "SELECT * FROM usuarios WHERE nombre LIKE ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nombre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombre);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final user _result;
      if(_cursor.moveToFirst()) {
        _result = new user();
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _result.uid = null;
        } else {
          _result.uid = _cursor.getString(_cursorIndexOfUid);
        }
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _result.nombre = null;
        } else {
          _result.nombre = _cursor.getString(_cursorIndexOfNombre);
        }
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _result.telefono = null;
        } else {
          _result.telefono = _cursor.getString(_cursorIndexOfTelefono);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
