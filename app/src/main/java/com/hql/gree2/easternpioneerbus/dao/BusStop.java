package com.hql.gree2.easternpioneerbus.dao;

import java.util.List;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table BUS_STOP.
 */
public class BusStop {

    private Long id;
    private long busLineId;
    private Integer stopIndex;
    private String stopName;
    private String stopDesc;
    private String class07;
    private String class09;
    private String class13;
    private String class17;

    /**
     * Used to resolve relations
     */
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    private transient BusStopDao myDao;

    private BusLine busLine;
    private Long busLine__resolvedKey;

    private List<BusStopImage> busStopImages;

    public BusStop() {
    }

    public BusStop(Long id) {
        this.id = id;
    }

    public BusStop(Long id, long busLineId, Integer stopIndex, String stopName, String stopDesc, String class07, String class09, String class13, String class17) {
        this.id = id;
        this.busLineId = busLineId;
        this.stopIndex = stopIndex;
        this.stopName = stopName;
        this.stopDesc = stopDesc;
        this.class07 = class07;
        this.class09 = class09;
        this.class13 = class13;
        this.class17 = class17;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBusStopDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBusLineId() {
        return busLineId;
    }

    public void setBusLineId(long busLineId) {
        this.busLineId = busLineId;
    }

    public Integer getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(Integer stopIndex) {
        this.stopIndex = stopIndex;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public String getClass07() {
        return class07;
    }

    public void setClass07(String class07) {
        this.class07 = class07;
    }

    public String getClass09() {
        return class09;
    }

    public void setClass09(String class09) {
        this.class09 = class09;
    }

    public String getClass13() {
        return class13;
    }

    public void setClass13(String class13) {
        this.class13 = class13;
    }

    public String getClass17() {
        return class17;
    }

    public void setClass17(String class17) {
        this.class17 = class17;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    public BusLine getBusLine() {
        long __key = this.busLineId;
        if (busLine__resolvedKey == null || !busLine__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BusLineDao targetDao = daoSession.getBusLineDao();
            BusLine busLineNew = targetDao.load(__key);
            synchronized (this) {
                busLine = busLineNew;
                busLine__resolvedKey = __key;
            }
        }
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        if (busLine == null) {
            throw new DaoException("To-one property 'busLineId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.busLine = busLine;
            busLineId = busLine.getId();
            busLine__resolvedKey = busLineId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<BusStopImage> getBusStopImages() {
        if (busStopImages == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BusStopImageDao targetDao = daoSession.getBusStopImageDao();
            List<BusStopImage> busStopImagesNew = targetDao._queryBusStop_BusStopImages(id);
            synchronized (this) {
                if (busStopImages == null) {
                    busStopImages = busStopImagesNew;
                }
            }
        }
        return busStopImages;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetBusStopImages() {
        busStopImages = null;
    }

    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

}
