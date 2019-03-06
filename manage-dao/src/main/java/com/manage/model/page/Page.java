package com.manage.model.page;

public class Page {
    private int draw;
    private int startIndex;
    private int pageSize;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDraw() {

        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public Page() {
    }

    public Page(int draw, int startIndex, int pageSize) {
        this.draw = draw;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "draw='" + draw + '\'' +
                ", startIndex='" + startIndex + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
