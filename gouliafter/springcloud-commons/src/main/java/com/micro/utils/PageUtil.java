package com.micro.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Hr
 * @BelongsPackage: com.hr.utils
 * @CreateTime: 2020-09-16 14:11
 * @Description: 通用的分页工具类
 */
public class PageUtil<T> {

    private long pageIndex;//当前页码
    private long pageSize;//页面大小
    private long totalcount; //总条数
    private long pageCount; //总页数
    private List<T> records; //分页的数据

    private long numberStart; //开始序号
    private long numberEnd; //结束序号
    private List<Integer> numbers=new ArrayList<Integer>(); //序号

    public PageUtil(long pageIndex, long pageSize, long totalcount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalcount = totalcount;
        this.records = records;
        //人工计算总页数
        this.pageCount=(this.totalcount%this.pageSize==0)?(this.totalcount/this.pageSize):(this.totalcount/this.pageSize+1);

        //给序号赋值
        if(this.pageCount<=10){
            this.numberStart=1;
            this.numberEnd=this.pageCount;
        }else{
            this.numberStart=this.pageIndex-4;
            this.numberEnd=this.pageIndex+5;
            if(this.numberStart<1){
                this.numberStart=1;
                this.numberEnd=10;
            }
            if(this.numberEnd>this.pageCount){
                this.numberStart=this.pageCount-9;
                this.numberEnd=this.pageCount;
            }
        }
        for(int i = (int) numberStart; i<=numberEnd; i++){
            numbers.add( i);
        }

    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(long totalcount) {
        this.totalcount = totalcount;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getNumberStart() {
        return numberStart;
    }

    public void setNumberStart(long numberStart) {
        this.numberStart = numberStart;
    }

    public long getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(long numberEnd) {
        this.numberEnd = numberEnd;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
