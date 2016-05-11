package com.example.ttyady.dentaku;

/**
 * Created by ttyady on 2016/05/06.
 */
public class Note {
    protected int id;
    protected Double result;
    protected String store;
    protected String memo;

    public Note(int id,Double result, String store, String memo){
        this.id = id;
        this.result = result;
        this.store = store;
        this.memo = memo;
    }
    public Double getResult(){
        return result;
    }
    public String getStore(){
        return store;
    }
    public String getMemo() { return memo; }
    public int getId(){
        return id;
    }
}
