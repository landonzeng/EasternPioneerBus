package com.hql.gree2.easternpioneerbus.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table BUS_LINE.
 */
public class BusLineDao extends AbstractDao<BusLine, Long> {

    public static final String TABLENAME = "BUS_LINE";

    /**
     * Properties of entity BusLine.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property LineIndex = new Property(1, Integer.class, "lineIndex", false, "LINE_INDEX");
        public final static Property LineName = new Property(2, String.class, "lineName", false, "LINE_NAME");
        public final static Property LineCode = new Property(3, String.class, "lineCode", false, "LINE_CODE");
        public final static Property LineSync = new Property(4, Boolean.class, "lineSync", false, "LINE_SYNC");
    }

    ;

    private DaoSession daoSession;


    public BusLineDao(DaoConfig config) {
        super(config);
    }

    public BusLineDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'BUS_LINE' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'LINE_INDEX' INTEGER," + // 1: lineIndex
                "'LINE_NAME' TEXT," + // 2: lineName
                "'LINE_CODE' TEXT," + // 3: lineCode
                "'LINE_SYNC' INTEGER);"); // 4: lineSync
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'BUS_LINE'";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, BusLine entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        Integer lineIndex = entity.getLineIndex();
        if (lineIndex != null) {
            stmt.bindLong(2, lineIndex);
        }

        String lineName = entity.getLineName();
        if (lineName != null) {
            stmt.bindString(3, lineName);
        }

        String lineCode = entity.getLineCode();
        if (lineCode != null) {
            stmt.bindString(4, lineCode);
        }

        Boolean lineSync = entity.getLineSync();
        if (lineSync != null) {
            stmt.bindLong(5, lineSync ? 1l : 0l);
        }
    }

    @Override
    protected void attachEntity(BusLine entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    public BusLine readEntity(Cursor cursor, int offset) {
        BusLine entity = new BusLine( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // lineIndex
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // lineName
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // lineCode
                cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0 // lineSync
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, BusLine entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLineIndex(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setLineName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLineCode(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLineSync(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(BusLine entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(BusLine entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

}
